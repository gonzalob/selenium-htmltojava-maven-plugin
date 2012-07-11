package dridco.seleniumhtmltojava.commands

class VerifyTextWithoutPrefixTest extends AbstractVerifyTextTest {

	@Override
	def protected target() {
		"//div[@id='foo']/h1[1]"
	}

	@Override
	def protected text() {
		"Verifying \${Some} \${Text}"
	}

	@Override
	def protected expectedResult() {
		"assertThat(\"verifyText(\\\"//div[@id='foo']/h1[1]\\\", \\\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\\\")\", selenium.getText(\"//div[@id=\'foo\']/h1[1]\"), containsString(\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\"));"
	}
}
