package dridco.seleniumhtmltojava.test;

import org.junit.Assert;
import org.junit.Test;

import dridco.seleniumhtmltojava.Functions;

public class FunctionsTest {

	@Test
	public void rendersDefaultTimeout() {
		Assert.assertEquals(
				"private void waitForPageToLoad(java.lang.String timeout) {"
						+ "int millis = Integer.valueOf(timeout);"
						+ "int actualTimeout;"
						+ "if(-1 > 0) { actualTimeout = -1; }"
						+ "else { actualTimeout = millis; }"
						+ "long start = System.currentTimeMillis();"
						+ "selenium.waitForPageToLoad(\"\" + actualTimeout);"
						+ "long duration = System.currentTimeMillis() - start;"
						+ "if(duration > millis) { logger.warning(java.text.MessageFormat.format(\"Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}\", millis, -1, duration)); }"
						+ "}", Functions.waitForPageToLoad.render());

	}

	@Test
	public void parsesForcedTimeout() {
		CustomGlobalsTemplate withCustomGlobals = new CustomGlobalsTemplate();
		withCustomGlobals.setForcedTimeout(30000);
		withCustomGlobals.execute(new CustomGlobalsCallback() {

			public void execute() {
				Assert.assertEquals(
						"private void waitForPageToLoad(java.lang.String timeout) {"
								+ "int millis = Integer.valueOf(timeout);"
								+ "int actualTimeout;"
								+ "if(30000 > 0) { actualTimeout = 30000; }"
								+ "else { actualTimeout = millis; }"
								+ "long start = System.currentTimeMillis();"
								+ "selenium.waitForPageToLoad(\"\" + actualTimeout);"
								+ "long duration = System.currentTimeMillis() - start;"
								+ "if(duration > millis) { logger.warning(java.text.MessageFormat.format(\"Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}\", millis, 30000, duration)); }"
								+ "}", Functions.waitForPageToLoad.render());
			}
		});
	}

}
