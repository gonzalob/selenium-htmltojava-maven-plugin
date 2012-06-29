package dridco.seleniumhtmltojava.commands

import org.junit.Test

class VerifyTextTest {

	@Test void simple() {
		new WithoutPrefix().canParseCommand()
	}

	@Test void regexp() {
		new Regexp().canParseCommand()
	}

	@Test void exact() {
		new Exact().canParseCommand()
	}

	abstract class AbstractVerifyTextCommand extends AbstractCommandTest {

		@Override
		def protected htmlInstructions() {
			"""
			<tr>
			<td>verifyText</td>
			<td>${target()}</td>
			<td>${text()}</td>
			</tr>
			"""
		}

		def protected abstract target()
		def protected abstract text()
	}

	class WithoutPrefix extends AbstractVerifyTextCommand {

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

	class Regexp extends AbstractVerifyTextCommand {

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
	
	class Exact extends AbstractVerifyTextCommand {

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
}
