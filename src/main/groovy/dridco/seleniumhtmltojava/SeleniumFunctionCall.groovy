package dridco.seleniumhtmltojava

import groovy.transform.TupleConstructor

@TupleConstructor
class SeleniumFunctionCall {

	def final call

	static def start() {
		new SeleniumFunctionCall("start()")
	}

	static def setTimeout(timeout) {
		new SeleniumFunctionCall("setTimeout(\"" + timeout + "\")")
	}

	static def setSpeed(speed) {
		new SeleniumFunctionCall("setSpeed(\"" + speed + "\")")
	}

	String toString() {
		TestVariables.SELENIUM + "." + call + ";"
	}
}
