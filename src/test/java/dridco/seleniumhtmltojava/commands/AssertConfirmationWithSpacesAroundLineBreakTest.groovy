package dridco.seleniumhtmltojava.commands

class AssertConfirmationWithSpacesAroundLineBreakTest extends AbstractAssertConfirmationTest {

	@Override
	def input() {
		buildString("<br />")
	}

	@Override
	def parsed() {
		buildString("\\\\n")
	}

	private static buildString(def lineBreak) {
		"A line " + lineBreak + " Another line"
	}
}
