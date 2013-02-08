package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.NormalizeJavaComponentName.from;

public class TestCaseName {

	private final String name;

	public TestCaseName(String source, String testClassesSuffix) {
		name = from(source).removeNonAlpha().prefixWithUnderscore()
				.addSuffix(testClassesSuffix).get();
	}

	public String normalize() {
		return name;
	}
}
