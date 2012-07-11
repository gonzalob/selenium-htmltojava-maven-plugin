package dridco.seleniumhtmltojava.commands

class VerifyTextRegexpTest extends AbstractVerifyTextTest {

	@Override
	def protected target() {
		"//span[@class='foo'][1]/a"
	}

	@Override
	def protected text() {
		"regexp:\${bar}"
	}

	@Override
	def protected expectedResult() {
		"assertThat(\"verifyText(\\\"//span[@class='foo'][1]/a\\\", \\\"regexp:\" + storage.get(\"bar\") + \"\\\")\", selenium.getText(\"//span[@class='foo'][1]/a\"), containsString(\"\" + storage.get(\"bar\") + \"\"));"
	}
}
