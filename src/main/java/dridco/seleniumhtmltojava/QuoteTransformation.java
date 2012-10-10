package dridco.seleniumhtmltojava;

import static java.lang.String.format;

public class QuoteTransformation implements Transformations {

	private String pattern;

	public QuoteTransformation(String pattern) {
		this.pattern = pattern;
	}

	public String javaCalls() {
		return format("java.util.regex.Pattern.quote(\"%s\")", pattern);
	}

}
