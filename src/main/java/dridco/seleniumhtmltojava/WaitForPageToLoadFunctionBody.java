package dridco.seleniumhtmltojava;

class WaitForPageToLoadFunctionBody implements FunctionBody {

	public String render() {
		return "int millis = Integer.valueOf(timeout);"
				+ "int actualTimeout;"
				+ "if(" + Globals.forcedTimeout() + " > 0) { actualTimeout = " + Globals.forcedTimeout() + "; }"
				+ "else { actualTimeout = millis; }"
				+ "long start = System.currentTimeMillis();"
				+ "selenium.waitForPageToLoad(\"\" + actualTimeout);"
				+ "long duration = System.currentTimeMillis() - start;"
				+ "if(duration > millis) { logger.warning(java.text.MessageFormat.format(\"Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}\", millis, " + Globals.forcedTimeout() + ", duration)); }";
	}

}
