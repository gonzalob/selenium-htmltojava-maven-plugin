package dridco.seleniumhtmltojava;

import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.EMPTY;

public class GlobTransformations implements Transformations {

	private String glob;

	public GlobTransformations(String pattern) {
		this.glob = pattern;
	}

	public String javaCalls() {
		return getPatternFromGlob();
	}

	private String getPatternFromGlob() {
		// http://stackoverflow.com/questions/1247772/is-there-an-equivalent-of-java-util-regex-for-glob-type-patterns#3619098
		return "\"^" + quoteStart() + "\" + \"" + globWithoutPrefix() + "\" + \"" + quoteEnd() + "$\"" + replaceStatement("*", ".*") + replaceStatement("?", ".");
	}
	
	private String replaceStatement(String replaced, String replacement) {
		return format(".replaceAll(\"" + replaced + "\", \"" + unquote(replacement) + "\")");
	}
	
	private String unquote(String replacement) {
		return quoteEnd() + replacement + quoteStart();
	}

	private String quoteStart() { return "\\\\Q"; }
	private String quoteEnd()   { return "\\\\E"; }

	private String globWithoutPrefix() {
		return glob.replace("glob:", EMPTY);
	}
}
