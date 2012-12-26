package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

public class WaitForVisibleFunctionCallback implements WaitForFunctionCallback {

	public String waitCondition(String targetArgumentName,
			String valueArgumentName) {
		return SELENIUM + ".isVisible(" + targetArgumentName + ")";
	}

}
