package dridco.seleniumhtmltojava.test

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import dridco.seleniumhtmltojava.JavaTestCompiler
import dridco.seleniumhtmltojava.SeleniumBuilderFixture

class JavaTestCompilerInstructionsTest {

	def testSource = """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head profile="http://selenium-ide.openqa.org/profiles/test-case">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="selenium.base" href="http://localhost/" />
<title>Some Title</title>
</head>
<body>
<table cellpadding="1" cellspacing="1" border="1">
<thead>
<tr><td rowspan="1" colspan="3">Some Name</td></tr>
</thead><tbody>
<tr>
	<td>open</td>
	<td>http://carros.demotores.com.co/</td>
	<td></td>
</tr>
<tr>
		<td>waitForPageToLoad</td>
		<td>30000</td>
		<td></td>
</tr>
			<tr>
			<td>waitForPageToLoad</td>
			<td></td>
			<td></td>
			</tr>
<tr>
		<td>deleteAllVisibleCookies</td>
		<td></td>
		<td>path=/sample,domain=localhost</td>
</tr>
<tr>
		<td>verifyTextNotPresent</td>
		<td>Some Text</td>
		<td></td>
</tr>
<tr>
		<td>verifyElementPresent</td>
		<td>//select[@id='an_id']</td>
		<td></td>
</tr>
<tr>
		<td>verifyTextPresent</td>
		<td>Some Text</td>
		<td></td>
</tr>
<tr>
		<td>type</td>
		<td>id=email</td>
		<td>foo@bar.com</td>
</tr>
<tr>
		<td>select</td>
		<td>id=an_id</td>
		<td>label=Some Text</td>
</tr>
<tr>
		<td>click</td>
		<td>id="an_input"</td>
		<td></td>
</tr>
<tr>
		<td>pause</td>
		<td>2000</td>
		<td></td>
</tr>
<tr>
		<td>storeEval</td>
		<td>var a = "";</td>
		<td>aString</td>
</tr>
<tr>
		<td>storeAttribute</td>
		<td>//div[@id=\'foo\']</td>
		<td>identifier</td>
</tr>
<tr>
		<td>echo</td>
		<td>\${FechaFinalizacionScript}</td>
		<td></td>
</tr>
<tr>
        <td>clickAndWait</td>
        <td>link=Some link</td>
        <td></td>
</tr>
<tr>
	<td>verifyText</td>
	<td>//div[@id='foo']/h1[1]</td>
	<td>Verifying \${Some} \${Text}</td>
</tr>
<tr>
        <td>verifyValue</td>
        <td>//input[@id='someId']</td>
        <td>\${value}</td>
</tr>
<tr>
        <td>verifyTitle</td>
        <td>The Title</td>
        <td></td>
</tr>
<tr>
        <td>verifyExpression</td>
        <td>\${source}</td>
        <td>\${target}</td>
</tr>
<tr>
        <td>verifyEval</td>
        <td>'\${something}'.replace('foo','').trim()</td>
        <td>\${other thing}</td>
</tr>
<tr>
        <td>verifyElementNotPresent</td>
        <td>//a[text()='aValue']</td>
        <td></td>
</tr>
<tr>
        <td>storeValue</td>
        <td>id=foo</td>
        <td>theName</td>
</tr>
<tr>
        <td>typeKeys</td>
        <td>id=t</td>
        <td>12</td>
</tr>
<tr>
        <td>storeText</td>
        <td>//div[@class='filter'][1]/a[@class='f'][1]</td>
        <td>storedText</td>
</tr>
<tr>
        <td>storeLocation</td>
        <td>URL</td>
        <td></td>
</tr>
<tr>
        <td>store</td>
        <td>123456</td>
        <td>hardcoded</td>
</tr>
<tr>
        <td>setTimeout</td>
        <td>100000</td>
        <td></td>
</tr>
<tr>
        <td>setSpeed</td>
        <td>50</td>
        <td></td>
</tr>
<tr>
        <td>selectWindow</td>
        <td>null</td>
        <td></td>
</tr>
<tr>
        <td>selectFrame</td>
        <td>relative=up</td>
        <td></td>
</tr>
<tr>
        <td>addSelection</td>
        <td>id=anId</td>
        <td>label=Foo</td>
</tr>
<tr>
        <td>removeSelection</td>
        <td>id=sel</td>
        <td>label=123</td>
</tr>
<tr>
        <td>assertTextPresent</td>
        <td>Blah</td>
        <td></td>
</tr>
<tr>
        <td>assertConfirmation</td>
        <td>Do something?</td>
        <td></td>
</tr>
<tr>
        <td>assertConfirmation</td>
        <td>Do something?</td>
        <td></td>
</tr>
<tr>
	<td>storeEval</td>
	<td>var a = ((storedVars['source']).indexOf('a')) + 1;</td>
	<td>target</td>
</tr>
<tr>
	<td>verifyText</td>
	<td>//span[@class='foo'][1]/a</td>
	<td>regexp:\${bar}</td>
</tr>
<tr>
	<td>verifyText</td>
	<td>//span[@class='foo'][2]/a</td>
	<td>exact:\${bar}:</td>
</tr>
<tr>
	<td>storeHtmlSource</td>
	<td>aVariable</td>
	<td></td>
</tr>
<tr>
	<td>clickAt</td>
	<td>id=some_id</td>
	<td></td>
</tr>
<tr>
    <td>waitForElementPresent</td>
    <td>an_element_id</td>
    <td></td>
</tr>
<tr>
	<td>refreshAndWait</td>
	<td></td>
	<td></td>
</tr>
</tbody></table>
	</body>
</html>
	"""

	def compiled

	@Before void compileJavaSource() {
		JavaTestCompiler compiler = new JavaTestCompiler(SeleniumBuilderFixture.BUILDER)
		compiled = compiler.compile testSource, "SomeTest"
	}

	@Test void canParseOpen() {
		assertThat compiled, containsString('selenium.open("http://carros.demotores.com.co/");')
	}

	@Test void canParseWaitForPageToLoadWithoutTimeoutByFailingTheTest() {
		assertThat compiled, containsString('fail("Found waitForPageToLoad without timeout defined");')
	}
	
	@Test void canParseWaitForPageToLoadWithTimeout() {
		assertThat compiled, containsString('selenium.waitForPageToLoad("30000");')
	}

	@Test void canParseDeleteAllVisibleCookies() {
		assertThat compiled, containsString('selenium.deleteAllVisibleCookies();')
	}

	@Test void canParseVerifyTextNotPresent() {
		assertThat compiled, containsString("assertFalse(\"verifyTextNotPresent(\\\"Some Text\\\", \\\"\\\")\", selenium.isTextPresent(\"Some Text\"));")
	}

	@Test void canParseVerifyElementPresent() {
		assertThat compiled, containsString("assertTrue(\"verifyElementPresent(\\\"//select[@id=\'an_id\']\\\", \\\"\\\")\", selenium.isElementPresent(\"//select[@id=\'an_id\']\"));")
	}

	@Test void canParseVerifyTextPresent() {
		assertThat compiled, containsString("assertTrue(\"verifyTextPresent(\\\"Some Text\\\", \\\"\\\")\", selenium.isTextPresent(\"Some Text\"));")
	}

	@Test void canParseType() {
		assertThat compiled, containsString('selenium.type("id=email", "foo@bar.com");')
	}

	@Test void canParseSelect() {
		assertThat compiled, containsString('selenium.select("id=an_id", "label=Some Text");')
	}

	@Test void canParseClick() {
		assertThat compiled, containsString('selenium.click("id=\\"an_input\\"");')
	}

	@Test void canParsePause() {
		assertThat compiled, containsString('try { Thread.sleep(2000); } catch (InterruptedException e) { fail(e.getMessage()); };')
	}

	@Test void canParseStoreEval() {
		assertThat compiled, containsString('storage.put("aString", selenium.getEval("var a = \\"\\";"));')
	}

	@Test void canParseStoreAttribute() {
		assertThat compiled, containsString('storage.put("identifier", selenium.getValue("//div[@id=\'foo\']"));')
	}

	@Test void canUseStoredValues() {
		assertThat compiled, containsString('storage.get("FechaFinalizacionScript")')
	}

	@Test void canParseEcho() {
		assertThat compiled, containsString('echo ')
	}

	@Test void canParseClickAndWait() {
		assertThat compiled, containsString('selenium.click("link=Some link");selenium.waitForPageToLoad("30000");')
	}

	@Test void canParseVerifyText() {
		assertThat compiled, containsString("assertThat(\"verifyText(\\\"//div[@id='foo']/h1[1]\\\", \\\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\\\")\", selenium.getText(\"//div[@id=\'foo\']/h1[1]\"), containsString(\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\"));")
	}

	@Test void canParseVerifyValue() {
		assertThat compiled, containsString('assertThat(\"verifyValue(\\\"//input[@id=\'someId\']\\\", \\\"" + storage.get("value") + "\\\")\", selenium.getValue("//input[@id=\'someId\']"), containsString("" + storage.get("value") + ""));')
	}

	@Test void canParseVerifyTitle() {
		assertThat compiled, containsString('assertThat(\"verifyTitle(\\\"The Title\\\", \\\"\\\")\", selenium.getTitle(), containsString("The Title"));')
	}

	@Test void canParseVerifyExpression() {
		assertThat compiled, containsString('assertThat(\"verifyExpression(\\\"" + storage.get("source") + "\\\", \\\"" + storage.get("target") + "\\\")\", selenium.getExpression("" + storage.get("source") + ""), containsString("" + storage.get("target") + ""));')
	}

	@Test void canParseVerifyEval() {
		assertThat compiled, containsString("assertEquals(\"verifyEval(\\\"\'\" + storage.get(\"something\") + \"\'.replace(\'foo\','').trim()\\\", \\\"\" + storage.get(\"other thing\") + \"\\\")\", selenium.getEval(\"\'\" + storage.get(\"something\") + \"\'.replace(\'foo\','').trim()\"), \"\" + storage.get(\"other thing\") + \"\");")
	}

	@Test void canParseVerifyElementNotPresent() {
		assertThat compiled, containsString('assertFalse(\"verifyElementNotPresent(\\\"//a[text()=\'aValue\']\\\", \\\"\\\")\", selenium.isElementPresent("//a[text()=\'aValue\']"));')
	}

	@Test void canParseStoreValue() {
		assertThat compiled, containsString('storage.put("theName", selenium.getValue("id=foo"));')
	}

	@Test void canParseTypeKeys() {
		assertThat compiled, containsString('selenium.typeKeys("id=t", "12");')
	}

	@Test void canParseStoreText() {
		assertThat compiled, containsString('storage.put("storedText", selenium.getText("//div[@class=\'filter\'][1]/a[@class=\'f\'][1]"));')
	}

	@Test void canParseStoreLocation() {
		assertThat compiled, containsString('storage.put("URL", selenium.getLocation());')
	}

	@Test void canParseStore() {
		assertThat compiled, containsString('storage.put("hardcoded", "123456");')
	}

	@Test void canParseSetTimeout() {
		assertThat compiled, containsString('selenium.setTimeout("100000");')
	}

	@Test void canParseSetSpeed() {
		assertThat compiled, containsString('selenium.setSpeed("50");')
	}

	@Test void canParseSelectWindow() {
		assertThat compiled, containsString('selenium.selectWindow("null");')
	}

	@Test void canParseSelectFrame() {
		assertThat compiled, containsString('selenium.selectFrame("relative=up");')
	}

	@Test void canParseAddSelection() {
		assertThat compiled, containsString('selenium.addSelection("id=anId", "label=Foo");')
	}

	@Test void canParseRemoveSelection() {
		assertThat compiled, containsString('selenium.removeSelection("id=sel", "label=123");')
	}

	@Test void canParseAssertTextPresent() {
		assertThat compiled, containsString('assertTrue(\"verifyTextPresent(\\\"Blah\\\", \\\"\\\")\", selenium.isTextPresent("Blah"));')
	}

	@Test void canParseAssertTitle() {
		canParseVerifyTitle()
	}

	@Test void canParseAssertText() {
		canParseVerifyText()
	}

	@Test void canParseElementPresent() {
		canParseVerifyElementPresent()
	}

	@Test void canParseAssertConfirmation() {
		assertThat compiled, containsString('assertEquals(\"assertConfirmation(\\\"Do something?\\\", \\\"\\\")\", "Do something?", selenium.getConfirmation());')
	}

	@Test void canParseStoredVars() {
		assertThat compiled, containsString('storage.put("target", selenium.getEval("var a = ((\\\"" + storage.get("source") + "\\\").indexOf(\'a\')) + 1;"));')
	}

	@Test void canParseVerifyTextRegexp() {
		assertThat compiled, containsString("assertThat(\"verifyText(\\\"//span[@class='foo'][1]/a\\\", \\\"regexp:\" + storage.get(\"bar\") + \"\\\")\", selenium.getText(\"//span[@class='foo'][1]/a\"), containsString(\"\" + storage.get(\"bar\") + \"\"));")
	}

	@Test void canParseVerifyTextExact() {
		assertThat compiled, containsString("assertEquals(\"verifyText(\\\"//span[@class='foo'][2]/a\\\", \\\"exact:\" + storage.get(\"bar\") + \":\\\")\", \"\" + storage.get(\"bar\") + \":\", selenium.getText(\"//span[@class='foo'][2]/a\"));")
	}

	@Test void canParseStoreHtmlSource() {
		assertThat compiled, containsString("storage.put(\"aVariable\", selenium.getHtmlSource());")
	}

	@Test void canParseClickAt() {
		assertThat compiled, containsString("selenium.clickAt(\"id=some_id\", \"\");")
	}

	@Test void canParseWaitForElementPresent() {
		assertThat compiled, containsString("{ int remainingAttempts = 60; while (remainingAttempts > 0) { if(selenium.isElementPresent(\"an_element_id\")) { break; } else { remainingAttempts--; try { Thread.sleep(500); } catch (InterruptedException e) { fail(e.getMessage()); } } } }")
	}
	
	@Test void canParseRefreshAndWait() {
		assertThat compiled, containsString('selenium.refresh();selenium.waitForPageToLoad("30000");')
	}
}
