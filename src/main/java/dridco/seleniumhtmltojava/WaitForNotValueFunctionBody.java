package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

class WaitForNotValueFunctionBody implements FunctionBody {

	public String render() {
		return "final int millisBetweenAttempts = 500;"
				+ "int remainingAttempts = " + Globals.timeout() + " / millisBetweenAttempts;"
				+ "boolean success = false;"
				+ "while (remainingAttempts > 0) {"
				+ "if(! value.equals(" + SELENIUM + ".getValue(target))) { success = true; break; }"
				+ "else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }"
				+ "}"
				+ "assertTrue(success);";
	}

}
