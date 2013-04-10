package dridco.seleniumhtmltojava

import org.junit.Assert
import org.junit.Test

class SeleniumFunctionCallTest {

	@Test void rendersGenericCall() {
		def function = new SeleniumFunctionCall("foo(2, \"a\")")
		Assert.assertEquals "selenium.foo(2, \"a\");", function.toString()
	}

	@Test void rendersCallToStart() {
		def function = SeleniumFunctionCall.start()
		Assert.assertEquals "selenium.start();", function.toString()
	}

	@Test void rendersCallToSetTimeout() {
		def function = SeleniumFunctionCall.setTimeout(0)
		Assert.assertEquals "selenium.setTimeout(\"0\");", function.toString()
	}

	@Test void rendersCallToSetSpeed() {
		def function = SeleniumFunctionCall.setSpeed(-1)
		Assert.assertEquals "selenium.setSpeed(\"-1\");", function.toString()
	}
}
