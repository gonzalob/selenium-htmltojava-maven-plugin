package dridco.seleniumhtmltojava.commands

class AssertConfirmationPlainTextTest extends AbstractAssertConfirmationTest {

	def text = "Do something?"

	@Override
	def input() {
		text
	}

	@Override
	def parsed() {
		text
	}
}
