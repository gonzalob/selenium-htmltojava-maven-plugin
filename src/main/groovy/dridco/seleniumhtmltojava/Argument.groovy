package dridco.seleniumhtmltojava

class Argument {

	private final String source
	private String parsed

	def Argument(final source) {
		this.source = source
	}

	public String parse() {
		initialize()
		escapeIllegalCharacters()
		parseDollarExpressions()
		parseStoredVars()
		removeExcessiveSlashes()
		parsed
	}

	private void initialize() {
		parsed = source
	}

	private void parseDollarExpressions() {
		parsed = parsed.replaceAll('\\$\\{([^\\}]*)\\}', '" + storage.get("$1") + "')
	}

	private void parseStoredVars() {
		parsed = parsed.replaceAll('storedVars\\[["\']([^"\']*)["\']\\]', "\\\\\"\" + storage.get(\"\$1\") + \"\\\\\"")
	}
	
	private void removeExcessiveSlashes() {
		parsed = parsed.replaceAll("storage.get\\(\\\\\"([^\"]*)\\\\\"\\)", "storage.get(\"\$1\")")
	}

	private void escapeIllegalCharacters() {
		parsed = parsed.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"")
	}
}
