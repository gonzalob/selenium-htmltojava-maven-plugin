package dridco.seleniumhtmltojava.commands

class VerifyTextWithoutPrefixTest extends AbstractVerifyTextTest {

	@Override
	def target() {
		"//div[@id='foo']/h1[1]"
	}

	@Override
	def text() {
		"Verifying \${Some} \${Text}"
	}

	@Override
	def expectedResult() {
		"assertThat(\"verifyText(\\\"//div[@id='foo']/h1[1]\\\", \\\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\\\")\", selenium.getText(\"//div[@id=\'foo\']/h1[1]\").toLowerCase(), containsString((\"Verifying \" + storage.get(\"Some\") + \" \" + storage.get(\"Text\") + \"\").toLowerCase()));"
	}
}
