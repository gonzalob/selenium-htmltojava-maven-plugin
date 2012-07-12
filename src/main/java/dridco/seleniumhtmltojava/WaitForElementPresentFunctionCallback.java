package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

class WaitForElementPresentFunctionCallback implements WaitForFunctionCallback {

	public String waitCondition(String targetArgumentName,
			String valueArgumentName) {
		return SELENIUM + ".isElementPresent(" + targetArgumentName + ")";
	}

}
