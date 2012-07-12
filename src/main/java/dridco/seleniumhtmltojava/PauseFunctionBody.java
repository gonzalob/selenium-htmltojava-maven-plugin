package dridco.seleniumhtmltojava;

class PauseFunctionBody implements FunctionBody {

	public String render() {
		return "try { Thread.sleep(millis); }"
				+ "catch (InterruptedException e) { fail(e.getMessage()); }";
	}
}
