package dridco.seleniumhtmltojava;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class TestCaseName {

	private final String name;

	public TestCaseName(String source, String testClassesSuffix) {
		name = toSafeName(source) + testClassesSuffix;
	}

	public String normalize() {
		return name;
	}

	private String toSafeName(String aName) {
		// underscore to avoid problems with names starting with numbers
		return '_' + toCamelCase(aName);
	}

	private String toCamelCase(String aName) {
		return aName.replaceAll("([^a-zA-Z0-9])*", EMPTY);
	}

}
