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
import static org.apache.commons.lang.StringEscapeUtils.*;
// generated with https://github.com/gonzalob/selenium-htmltojava-maven-plugin
public class _TheCasesTitleITCase {
private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("_TheCasesTitleITCase");
private final com.thoughtworks.selenium.Selenium selenium;
private final java.util.Map<String, String> storage = new java.util.HashMap<String, String>();
private final boolean verbose;
public _TheCasesTitleITCase() { try { selenium = new com.thoughtworks.selenium.DefaultSelenium("localhost", 4444, "*firefox", "http://sample-host/"); verbose = false; } catch(RuntimeException e) { throw e; } catch(Exception e) { throw new RuntimeException(e); } }
@org.junit.Before public void setUp() { logStart(); prepareSeleniumSession(); }
@org.junit.After public void tearDown() { closeSeleniumSession(); logEnd(); } 
private void prepareSeleniumSession() { selenium.start(); selenium.setSpeed("0"); selenium.setTimeout("30000"); }
private void closeSeleniumSession() { selenium.stop(); }
private void logStart() { log("started"); }
private void logEnd() { log("ended"); }
private void pause(java.lang.Integer millis) {try { Thread.sleep(millis); }catch (InterruptedException e) { fail(e.getMessage()); }}private void waitForPageToLoad(java.lang.String timeout) {int millis = Integer.valueOf(timeout);int actualTimeout;if(-1 > 0) { actualTimeout = -1; }else { actualTimeout = millis; }long start = System.currentTimeMillis();selenium.waitForPageToLoad("" + actualTimeout);long duration = System.currentTimeMillis() - start;if(duration > millis) { logger.warning(java.text.MessageFormat.format("Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}", millis, -1, duration)); }}private void waitForElementPresent(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isElementPresent(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForTextPresent(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isTextPresent(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForEditable(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isEditable(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForNotValue(java.lang.String target,java.lang.String value) {final int millisBetweenAttempts = 500;int remainingAttempts = 30000 / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(! value.equals(selenium.getValue(target))) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForVisible(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isVisible(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void open(java.lang.String page) {if(-1 > 0) {String currentTimeout = selenium.getEval("selenium.defaultTimeout");if("".equals(currentTimeout)) { currentTimeout = "30000"; }selenium.setTimeout("-1");try {long start = System.currentTimeMillis();selenium.open(page);long duration = System.currentTimeMillis() - start;if(duration > java.lang.Long.valueOf(currentTimeout)) { logger.warning(java.text.MessageFormat.format("Timeout insufficient opening {0}. Declared: {1}, Forced: {2}, Actual: {3}", page, currentTimeout, -1, duration)); }} finally { selenium.setTimeout(currentTimeout); }} else { selenium.open(page); }}
private void log(String event) { if(verbose) { logger.info("Test " + getClass().getName() + " " + event + " at " + new java.util.Date()); } }
@org.junit.Test(timeout = 0L) public void testMethod() {}}"""

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
import static org.apache.commons.lang.StringEscapeUtils.*;
// generated with https://github.com/gonzalob/selenium-htmltojava-maven-plugin
public class _TheCasesTitleITCase {
private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("_TheCasesTitleITCase");
private final com.thoughtworks.selenium.Selenium selenium;
private final java.util.Map<String, String> storage = new java.util.HashMap<String, String>();
private final boolean verbose;
public _TheCasesTitleITCase() { try { selenium = new com.thoughtworks.selenium.DefaultSelenium("localhost", 4444, "*firefox", "http://sample-host/"); verbose = false; } catch(RuntimeException e) { throw e; } catch(Exception e) { throw new RuntimeException(e); } }
@org.junit.Before public void setUp() { logStart(); prepareSeleniumSession(); }
@org.junit.After public void tearDown() { closeSeleniumSession(); logEnd(); } 
private void prepareSeleniumSession() { selenium.start(); selenium.setSpeed("0"); selenium.setTimeout("30000"); }
private void closeSeleniumSession() { selenium.stop(); }
private void logStart() { log("started"); }
private void logEnd() { log("ended"); }
private void pause(java.lang.Integer millis) {try { Thread.sleep(millis); }catch (InterruptedException e) { fail(e.getMessage()); }}private void waitForPageToLoad(java.lang.String timeout) {int millis = Integer.valueOf(timeout);int actualTimeout;if(-1 > 0) { actualTimeout = -1; }else { actualTimeout = millis; }long start = System.currentTimeMillis();selenium.waitForPageToLoad("" + actualTimeout);long duration = System.currentTimeMillis() - start;if(duration > millis) { logger.warning(java.text.MessageFormat.format("Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}", millis, -1, duration)); }}private void waitForElementPresent(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isElementPresent(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForTextPresent(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isTextPresent(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForEditable(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isEditable(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForNotValue(java.lang.String target,java.lang.String value) {final int millisBetweenAttempts = 500;int remainingAttempts = 30000 / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(! value.equals(selenium.getValue(target))) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void waitForVisible(java.lang.String element,java.lang.String timeout) {int millis = Integer.valueOf(timeout);if(-1 > millis) { millis = -1; }final int millisBetweenAttempts = 500;int remainingAttempts = millis / millisBetweenAttempts;boolean success = false;while (remainingAttempts > 0) {if(selenium.isVisible(element)) { success = true; break; }else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }}assertTrue(success);}private void open(java.lang.String page) {if(-1 > 0) {String currentTimeout = selenium.getEval("selenium.defaultTimeout");if("".equals(currentTimeout)) { currentTimeout = "30000"; }selenium.setTimeout("-1");try {long start = System.currentTimeMillis();selenium.open(page);long duration = System.currentTimeMillis() - start;if(duration > java.lang.Long.valueOf(currentTimeout)) { logger.warning(java.text.MessageFormat.format("Timeout insufficient opening {0}. Declared: {1}, Forced: {2}, Actual: {3}", page, currentTimeout, -1, duration)); }} finally { selenium.setTimeout(currentTimeout); }} else { selenium.open(page); }}
private void log(String event) { if(verbose) { logger.info("Test " + getClass().getName() + " " + event + " at " + new java.util.Date()); } }
@org.junit.Test(timeout = 0L) public void testMethod() {}}"""

		tested = new JavaTestCompiler(SeleniumBuilderFixture.BUILDER)
		def actualCompilation = tested.compile testSource, "TheCasesTitle", testPackage
		assertEquals compiled, actualCompilation
	}
}
