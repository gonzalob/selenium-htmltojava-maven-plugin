package dridco.seleniumhtmltojava

import groovy.transform.TupleConstructor

@TupleConstructor
final class DefaultSeleniumBuilder implements SeleniumBuilder {

	def serverHost
	def serverPort
	def browser
	def baseUrl

	def build(base) {
		String.format("%s = new com.thoughtworks.selenium.DefaultSelenium(\"%s\", %s, \"%s\", \"%s\")",
				TestVariables.SELENIUM, serverHost, serverPort, browser, base ?: baseUrl)
	}

	def start() {
		[
			SeleniumFunctionCall.start(),
			SeleniumFunctionCall.setSpeed(Globals.speed()),
			SeleniumFunctionCall.setTimeout(Globals.timeout()),
		].collect { it.toString() }.join()
	}
}
