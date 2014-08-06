package dridco.seleniumhtmltojava;

import static java.lang.String.format;

public class NotFunctionBody implements WaitForFunctionCallback {

	private WaitForFunctionCallback inner;

	public NotFunctionBody(WaitForFunctionCallback inner) {
		this.inner = inner;
	}

	@Override
	public String waitCondition(String targetArgumentName, String valueArgumentName) {
		return format("!(%s)", inner.waitCondition(targetArgumentName, valueArgumentName));
	}
}
