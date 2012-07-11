package dridco.seleniumhtmltojava.commands

class VerifyTextExactTest extends AbstractVerifyTextTest {

	@Override
	def protected target() {
		"//span[@class='foo'][2]/a"
	}

	@Override
	def protected text() {
		"exact:\${bar}:"
	}

	@Override
	def protected expectedResult() {
		"assertEquals(\"verifyText(\\\"//span[@class='foo'][2]/a\\\", \\\"exact:\" + storage.get(\"bar\") + \":\\\")\", \"\" + storage.get(\"bar\") + \":\", selenium.getText(\"//span[@class='foo'][2]/a\"));"
	}
}
