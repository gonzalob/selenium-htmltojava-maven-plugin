package dridco.seleniumhtmltojava.commands

import org.junit.Test

class WaitForPageToLoadTest {

	@Test void withTimeout() {
		new WithTimeout().canParseCommand()
	}

	@Test void withoutTimeout() {
		new WithoutTimeout().canParseCommand()
	}

	abstract class AbstractWaitForPageToLoadCommand extends AbstractCommandTest {

		@Override
		def htmlInstructions() {
			"""
			<tr>
			<td>waitForPageToLoad</td>
			<td>${timeout()}</td>
			<td></td>
			</tr>
			"""
		}

		def abstract timeout()
	}

	class WithTimeout extends AbstractWaitForPageToLoadCommand {

		@Override
		def expectedResult() {
			'waitForPageToLoad("30000");'
		}

		@Override
		def timeout() {
			"30000"
		}
	}

	class WithoutTimeout extends AbstractWaitForPageToLoadCommand {

		@Override
		def expectedResult() {
			'waitForPageToLoad("");'
		}

		@Override
		def timeout() {
			""
		}
	}
}
