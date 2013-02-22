package dridco.seleniumhtmltojava

import static org.apache.commons.lang.StringUtils.EMPTY

public class JavaTestCompiler {

	private static final DEFAULT_TESTNAME_SUFFIX = "ITCase"

	private final seleniumBuilder

	private final testNameSuffix

	public JavaTestCompiler(builder) {
		this(builder, DEFAULT_TESTNAME_SUFFIX)
	}

	public JavaTestCompiler(builder, String suffix) {
		seleniumBuilder = builder
		testNameSuffix = suffix
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
			def value = ""
			it.td[1].each {
				if(it instanceof Node) {
					value += " \\n " // so far, i've only encountered br's when not strings. KISS
				} else value += it
			}
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
import static org.apache.commons.lang.StringEscapeUtils.*;
// generated with https://github.com/gonzalob/selenium-htmltojava-maven-plugin
public class ${resolvedName} {
private final java.util.logging.Logger ${TestVariables.LOGGER} = java.util.logging.Logger.getLogger("${resolvedName}");
private final com.thoughtworks.selenium.Selenium ${TestVariables.SELENIUM};
private final java.util.Map<String, String> ${TestVariables.STORAGE} = new java.util.HashMap<String, String>();
private final boolean verbose;
public ${resolvedName}() { ${TestVariables.SELENIUM} = ${seleniumImplementation} verbose = ${Globals.verbose()}; }
@org.junit.Before public void setUp() { logStart(); prepareSeleniumSession(); }
@org.junit.After public void tearDown() { closeSeleniumSession(); logEnd(); } 
private void prepareSeleniumSession() { ${TestVariables.SELENIUM}.start(); ${TestVariables.SELENIUM}.setSpeed("${Globals.speed()}"); ${TestVariables.SELENIUM}.setTimeout("${Globals.timeout()}"); }
private void closeSeleniumSession() { ${TestVariables.SELENIUM}.stop(); }
private void logStart() { log("started"); }
private void logEnd() { log("ended"); }
${functions()}
private void log(String event) { if(verbose) { logger.info("Test " + getClass().getName() + " " + event + " at " + new java.util.Date()); } }
@org.junit.Test(timeout = ${Globals.testTimeout()}L) public void testMethod() {${commands}}}""".toString()
	}

	private String functions() {
		StringBuilder functions = new StringBuilder()
		for (Functions function : Functions.values()) {
			functions.append function.render() 
		}
		functions
	}
}
