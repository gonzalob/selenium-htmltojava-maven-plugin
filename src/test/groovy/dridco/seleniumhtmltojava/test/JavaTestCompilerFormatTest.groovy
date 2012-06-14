package dridco.seleniumhtmltojava.test

import static org.junit.Assert.assertEquals

import org.junit.Test

import dridco.seleniumhtmltojava.JavaTestCompiler
import dridco.seleniumhtmltojava.SeleniumBuilderFixture

class JavaTestCompilerFormatTest {

	JavaTestCompiler tested
	def testSource = """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head profile="http://selenium-ide.openqa.org/profiles/test-case">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="selenium.base" href="http://sample-host/" />
<title>The Case's Title</title>
</head>
<body>
<table cellpadding="1" cellspacing="1" border="1">
<thead>
<tr><td rowspan="1" colspan="3">The Case's Name</td></tr>
</thead><tbody>
</tbody></table>
</body>
</html>
	"""

	@Test void canCompileTestWithoutPackage() {
		def compiled = """
package _integrationtests;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
public class _TheCasesTitleITCase {
private com.thoughtworks.selenium.Selenium selenium;
private java.util.Map<String, String> storage = new java.util.HashMap<String, String>();
public _TheCasesTitleITCase() { selenium = new com.thoughtworks.selenium.DefaultSelenium("localhost", 4444, "*firefox", "http://sample-host/"); }
@org.junit.Before public void prepareSeleniumSession() { selenium.start(); selenium.setSpeed("0"); selenium.setTimeout("30000"); }
@org.junit.After public void closeSeleniumSession() { selenium.stop(); }
public void waitForElementPresent(String element, int timeout) { final int millisBetweenAttempts = 500; int remainingAttempts = timeout / millisBetweenAttempts; while (remainingAttempts > 0) { if(selenium.isElementPresent(element)) { break; } else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } } } }
public void waitForPageToLoad(int millis) { try { Thread.sleep(millis); } catch (InterruptedException e) { fail(e.getMessage()); } }
@org.junit.Test
public void testMethod() {}}"""

		tested = new JavaTestCompiler(SeleniumBuilderFixture.BUILDER)
		def actualCompilation = tested.compile testSource, "TheCasesTitle"
		assertEquals compiled, actualCompilation
	}

	@Test void canCompileTestWithoutSteps() {
		def testPackage = "demotoressamples"
		def compiled = """
package _demotoressamples;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
public class _TheCasesTitleITCase {
private com.thoughtworks.selenium.Selenium selenium;
private java.util.Map<String, String> storage = new java.util.HashMap<String, String>();
public _TheCasesTitleITCase() { selenium = new com.thoughtworks.selenium.DefaultSelenium("localhost", 4444, "*firefox", "http://sample-host/"); }
@org.junit.Before public void prepareSeleniumSession() { selenium.start(); selenium.setSpeed("0"); selenium.setTimeout("30000"); }
@org.junit.After public void closeSeleniumSession() { selenium.stop(); }
public void waitForElementPresent(String element, int timeout) { final int millisBetweenAttempts = 500; int remainingAttempts = timeout / millisBetweenAttempts; while (remainingAttempts > 0) { if(selenium.isElementPresent(element)) { break; } else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } } } }
public void waitForPageToLoad(int millis) { try { Thread.sleep(millis); } catch (InterruptedException e) { fail(e.getMessage()); } }
@org.junit.Test
public void testMethod() {}}"""

		tested = new JavaTestCompiler(SeleniumBuilderFixture.BUILDER)
		def actualCompilation = tested.compile testSource, "TheCasesTitle", testPackage
		assertEquals compiled, actualCompilation
	}
}
