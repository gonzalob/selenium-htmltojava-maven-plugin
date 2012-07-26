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

	def private buildString(def lineBreak) {
		"A line " + lineBreak + " Another line"
	}
}
