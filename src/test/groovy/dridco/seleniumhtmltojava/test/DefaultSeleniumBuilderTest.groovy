package dridco.seleniumhtmltojava.test

import static org.apache.commons.lang.StringUtils.EMPTY
import static org.junit.Assert.assertEquals

import org.junit.Test

import dridco.seleniumhtmltojava.DefaultSeleniumBuilder

class DefaultSeleniumBuilderTest {

	@Test
	public void rendersTheBuilderWithExpectedParameters() {
		def tested = new DefaultSeleniumBuilder("localhost", 4444, "*firefox", "http://localhost")
		assertEquals(
				"new com.thoughtworks.selenium.DefaultSelenium(\"localhost\", 4444, \"*firefox\", \"http://localhost\")",
				tested.build(EMPTY))
	}

	@Test
	public void rendersTheStartInstruction() {
		def WHATEVER
		assertEquals("selenium.start()", new DefaultSeleniumBuilder(WHATEVER,
				WHATEVER, WHATEVER, WHATEVER).start())
	}
}
