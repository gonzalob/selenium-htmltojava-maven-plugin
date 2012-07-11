package dridco.seleniumhtmltojava.commands

import org.apache.commons.lang.StringEscapeUtils;

class VerifyTextWithLineBreakTest extends AbstractVerifyTextTest {

	@Override
	def protected target() {
		"css=div.a_class > span"
	}

	@Override
	def protected text() {
		"Something!&lt;br /&gt; Else!"
	}

	@Override
	def protected expectedResult() {
		"assertThat(\"verifyText(\\\"css=div.a_class > span\\\", \\\"Something!<br /> Else!\\\")\", selenium.getText(\"css=div.a_class > span\"), containsString(\"Something!\n Else!\"));"
	}
}
