package dridco.seleniumhtmltojava;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class NormalizeJavaComponentName {

	public static NormalizeJavaComponentName from(String source) {
		return new NormalizeJavaComponentName(source);
	}

	private String source;

	private NormalizeJavaComponentName(String source) {
		this.source = source;
	}

	public NormalizeJavaComponentName removeNonAlpha() {
		source = source.replaceAll("([^a-zA-Z0-9])*", EMPTY);
		return this;
	}

	public NormalizeJavaComponentName prefixWithUnderscore() {
		// underscore to avoid problems with names starting with numbers
		source = "_" + source;
		return this;
	}

	public String get() {
		return source;
	}

	public NormalizeJavaComponentName addSuffix(String suffix) {
		source += suffix;
		return this;
	}
}
