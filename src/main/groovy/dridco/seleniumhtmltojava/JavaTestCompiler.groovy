package dridco.seleniumhtmltojava

import static org.apache.commons.lang.StringUtils.EMPTY

public class JavaTestCompiler {

	private static final String DEFAULT_TESTNAME_SUFFIX = "ITCase"

	private final SeleniumBuilder seleniumBuilder

	private final def testNameSuffix

	public JavaTestCompiler(SeleniumBuilder aBuilder) {
		this(aBuilder, DEFAULT_TESTNAME_SUFFIX)
	}

	public JavaTestCompiler(SeleniumBuilder aBuilder, String aSuffix) {
		seleniumBuilder = aBuilder
		testNameSuffix = aSuffix
	}

	String compile(testSource, fileName, testPackage = EMPTY) {
		def resolvedPackage = new TestCaseName(testPackage ?: "integration_tests", EMPTY).normalize()

		def parser = new XmlParser()
		/* disabled dtd validation, these xmls are supposed to be built by an automated tool, 
		 added to the fact that the dtd for xhtml1 takes forever to download */
		parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)
		def html = parser.parseText(testSource)
		def steps = html.body.table.tbody.tr
		def candidateBase = html.head.link.find { it.'@rel'.equals('selenium.base') }
		def base
		if(candidateBase) {
			base = candidateBase.'@href'
		}
		def seleniumImplementation = seleniumBuilder.build(base)
		def commands = new StringBuilder()
		steps.each {
			def commandName = it.td[0].text()
			def value = it.td[1].text()
			def additional = it.td[2].text()
			def command
			try {
				command = Commands.valueOf(commandName)
			} catch(e) {
				command = Commands.__unknown__
				value = commandName
			}
			commands.append new Command(command, value, additional).build() + "\n"
		}

		def resolvedName = new TestCaseName(fileName, testNameSuffix).normalize()

		"""
package ${resolvedPackage};
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.apache.commons.lang.StringEscapeUtils.escapeJavaScript;
public class ${resolvedName} {
private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("${resolvedName}");
private final com.thoughtworks.selenium.Selenium ${TestVariables.SELENIUM};
private final java.util.Map<String, String> ${TestVariables.STORAGE} = new java.util.HashMap<String, String>();
public ${resolvedName}() { ${TestVariables.SELENIUM} = ${seleniumImplementation} }
@org.junit.Before public void prepareSeleniumSession() { ${TestVariables.SELENIUM}.start(); ${TestVariables.SELENIUM}.setSpeed("${Globals.speed()}"); ${TestVariables.SELENIUM}.setTimeout("${Globals.timeout()}"); }
@org.junit.After public void closeSeleniumSession() { ${TestVariables.SELENIUM}.stop(); }
${functions()}
@org.junit.Test public void testMethod() {${commands}}}""".toString()
	}

	private String functions() {
		StringBuilder functions = new StringBuilder();
		for (Functions function : Functions.values()) {
			functions.append function.render() ;
		}
		return functions;
	}
}
