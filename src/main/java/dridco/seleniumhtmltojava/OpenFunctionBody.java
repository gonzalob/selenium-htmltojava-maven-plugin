package dridco.seleniumhtmltojava;

/**
 * Temporarily change the timeout when a forced timeout is defined, as open() does an implicit andWait()
 */
public class OpenFunctionBody implements FunctionBody {

	static final String URL_PARAMETER = "page";

	public String render() {
		return "if(" + Globals.forcedTimeout() + " > 0) {"
				// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/PmByblFSfJc
				+ "String currentTimeout = selenium.getEval(\"selenium.defaultTimeout\");"
				+ TestVariables.SELENIUM + ".setTimeout(\"" + Globals.forcedTimeout() + "\");"
				+ "try {"
				+ "long start = System.currentTimeMillis();"
				+ TestVariables.SELENIUM + ".open(" + URL_PARAMETER + ");"
				+ "long duration = System.currentTimeMillis() - start;"
				+ "if(duration > java.lang.Long.valueOf(currentTimeout)) { logger.warning(java.text.MessageFormat.format(\"Timeout insufficient opening {0}. Declared: {1}, Forced: {2}, Actual: {3}\", page, currentTimeout, " + Globals.forcedTimeout() + ", duration)); }"
				+ "} finally { " + TestVariables.SELENIUM + ".setTimeout(currentTimeout); }"
				+ "} else { " + TestVariables.SELENIUM + ".open(" + URL_PARAMETER + "); }";
	}
}
