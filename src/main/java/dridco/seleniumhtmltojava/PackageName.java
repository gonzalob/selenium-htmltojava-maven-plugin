package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.NormalizeJavaComponentName.from;

public class PackageName {

	private final String name;

	public PackageName(String source) {
		name = from(source).removeNonAlpha().prefixWithUnderscore().get();
	}

	public String normalize() {
		return name;
	}
}
