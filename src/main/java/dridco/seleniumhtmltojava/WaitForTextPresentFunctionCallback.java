package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

class WaitForTextPresentFunctionCallback implements WaitForFunctionCallback {

	public String waitCondition(String targetArgumentName,
			String valueArgumentName) {
		return SELENIUM + ".isTextPresent(" + targetArgumentName + ")";
	}

}
