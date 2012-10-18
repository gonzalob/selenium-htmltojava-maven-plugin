package dridco.seleniumhtmltojava;

public class GlobTransformations implements Transformations {
	
	private static final String ESCAPED_SLASH = "\\\\";
	private final String glob;

	public GlobTransformations(String pattern) {
		this.glob = pattern;
	}

	public String javaCalls() {
		return getPatternFromGlob();
	}

	private String getPatternFromGlob() {
		return "\"^" + quoteStart() + "\" + (\"" + globWithoutPrefix() + "\")" + replaceStatement(ESCAPED_SLASH + "*", ".*") + replaceStatement(ESCAPED_SLASH + "?", ".") + " + \"" + quoteEnd() + "$\"";
	}

	private String replaceStatement(String replaced, String replacement) {
		return ".replaceAll(\"" + replaced + "\", \"" + unquote(replacement) + "\")";
	}

	private String unquote(String replacement) {
		return escapedEnd() + replacement + escapedStart();
	}

	private String escapedStart() {
		return ESCAPED_SLASH + quoteStart();
	}

	private String escapedEnd() {
		return ESCAPED_SLASH + quoteEnd();
	}

	private String quoteStart() {
		return ESCAPED_SLASH + "Q";
	}

	private String quoteEnd() {
		return ESCAPED_SLASH + "E";
	}

	private String globWithoutPrefix() {
		return glob.replace("glob:", "");
	}
}
