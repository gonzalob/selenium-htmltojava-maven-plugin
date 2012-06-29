package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.junit.Test

abstract class AbstractCommandTest {

	@Test void canParseCommand() {
		def script = new ScriptBuilder()
		script.commands << htmlInstructions()
		assertThat script.compile(), containsString(expectedResult())
	}

	def protected abstract htmlInstructions()

	def protected abstract expectedResult()
}
