package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

class WaitForNotValueFunctionBody implements FunctionBody {

	static final String TARGET_PARAMETER_NAME = "target";
	static final String VALUE_PARAMETER_NAME = "value";
	
	public String render() {
		return "final int millisBetweenAttempts = 500;"
				+ "int remainingAttempts = " + Globals.timeout() + " / millisBetweenAttempts;"
				+ "boolean success = false;"
				+ "while (remainingAttempts > 0) {"
				+ "if(! " + VALUE_PARAMETER_NAME + ".equals(" + SELENIUM + ".getValue(" + TARGET_PARAMETER_NAME + "))) { success = true; break; }"
				+ "else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }"
				+ "}"
				+ "assertTrue(success);";
	}
}
