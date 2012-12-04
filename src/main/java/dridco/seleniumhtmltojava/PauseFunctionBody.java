package dridco.seleniumhtmltojava;

class PauseFunctionBody implements FunctionBody {

	static final String TIMEOUT_PARAMETER_NAME = "millis";
	
	public String render() {
		return "try { Thread.sleep(" + TIMEOUT_PARAMETER_NAME + "); }"
				+ "catch (InterruptedException e) { fail(e.getMessage()); }";
	}
}
