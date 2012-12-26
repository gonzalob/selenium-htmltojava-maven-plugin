package dridco.seleniumhtmltojava.commands

class VerifyTextExactTest extends AbstractVerifyTextTest {

	@Override
	def target() {
		"//span[@class='foo'][2]/a"
	}

	@Override
	def text() {
		"exact:\${bar}:"
	}

	@Override
	def expectedResult() {
		"assertEquals(\"verifyText(\\\"//span[@class='foo'][2]/a\\\", \\\"exact:\" + storage.get(\"bar\") + \":\\\")\", \"\" + storage.get(\"bar\") + \":\", selenium.getText(\"//span[@class='foo'][2]/a\"));"
	}
}
