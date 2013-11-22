package dridco.seleniumhtmltojava.test

import static org.apache.commons.lang.StringUtils.EMPTY
import static org.junit.Assert.assertEquals

import org.junit.Test

import dridco.seleniumhtmltojava.DefaultSeleniumBuilder

class DefaultSeleniumBuilderTest {

	def WHATEVER

	@Test
	public void rendersTheBuilderWithExpectedParameters() {
		def tested = new DefaultSeleniumBuilder("localhost", 4444, "*firefox", "http://localhost")
		assertEquals(
				"selenium = new com.thoughtworks.selenium.DefaultSelenium(\"localhost\", 4444, \"*firefox\", \"http://localhost\")",
				tested.build(EMPTY))
	}

	@Test
	public void rendersTheStartInstruction() {
		assertEquals("selenium.start();selenium.setSpeed(\"0\");selenium.setTimeout(\"30000\");", new DefaultSeleniumBuilder(WHATEVER,
				WHATEVER, WHATEVER, WHATEVER).start())
	}

	@Test void declaresNoVariables() {
		assertEquals EMPTY, new DefaultSeleniumBuilder(WHATEVER, WHATEVER, WHATEVER, WHATEVER).instanceVariables()
	}
}
