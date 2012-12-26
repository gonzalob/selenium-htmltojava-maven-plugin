package dridco.seleniumhtmltojava.commands

class VerifyTextRegexpTest extends AbstractVerifyTextTest {

	@Override
	def target() {
		"//span[@class='foo'][1]/a"
	}

	@Override
	def text() {
		"regexp:\${bar}"
	}

	@Override
	def expectedResult() {
		"assertThat(\"verifyText(\\\"//span[@class='foo'][1]/a\\\", \\\"regexp:\" + storage.get(\"bar\") + \"\\\")\", selenium.getText(\"//span[@class='foo'][1]/a\"), containsString(\"\" + storage.get(\"bar\") + \"\"));"
	}
}
