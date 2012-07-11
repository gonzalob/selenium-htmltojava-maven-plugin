package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.apache.commons.logging.LogFactory;
import org.junit.Test

abstract class AbstractCommandTest {
	
	def logger
	
	public AbstractCommandTest() {
		logger = LogFactory.getLog(getClass())
	}

	@Test void canParseCommand() {
		def script = new ScriptBuilder()
		script.commands << htmlInstructions()
		def compiled = script.compile()
		logger.debug compiled
		assertThat compiled, containsString(expectedResult())
	}

	def protected abstract htmlInstructions()

	def protected abstract expectedResult()
}
