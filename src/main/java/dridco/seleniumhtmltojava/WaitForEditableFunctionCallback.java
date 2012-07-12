package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

class WaitForEditableFunctionCallback implements WaitForFunctionCallback {

	public String waitCondition(String targetArgumentName,
			String valueArgumentName) {
		return SELENIUM + ".isEditable(" + targetArgumentName + ")";
	}

}
