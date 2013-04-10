package dridco.seleniumhtmltojava

import groovy.transform.TupleConstructor

@TupleConstructor
class RemoteWebDriverBackedSeleniumBuilder implements SeleniumBuilder {

	def serverHost
	def serverPort
	def browser
	def baseUrl

	Map capabilities = [:]
	Map preferences = [:]

	def CAPABILITIES_MAP_NAME = "capabilities"
	def PROFILE_NAME = "profile"

	def DRIVER_VAR_NAME = "driver"

	def build(base) {
		def renderedCapabilities = ""
		def profilePreferences = ""
		capabilities.each { renderedCapabilities += CAPABILITIES_MAP_NAME + """.put("${it.key}", ${it.value});""" }
		preferences.each { profilePreferences += PROFILE_NAME + """.setPreference("${it.key}", ${it.value});""" }
		"""
org.openqa.selenium.firefox.FirefoxProfile ${PROFILE_NAME} = new org.openqa.selenium.firefox.FirefoxProfile();${profilePreferences}
java.util.HashMap ${CAPABILITIES_MAP_NAME} = new java.util.HashMap(); ${CAPABILITIES_MAP_NAME}.put("firefox_profile", ${PROFILE_NAME});${renderedCapabilities}
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(${CAPABILITIES_MAP_NAME}); custom.merge(firefox);
${DRIVER_VAR_NAME} = new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://${serverHost}:${serverPort}/wd/hub"), custom);
${TestVariables.SELENIUM} = new org.openqa.selenium.WebDriverBackedSelenium(driver, "${base ?: baseUrl}")""".toString()
	}

	def start() {
		[
			SeleniumFunctionCall.setSpeed(Globals.speed()),
			SeleniumFunctionCall.setTimeout(Globals.timeout()),
			"""${DRIVER_VAR_NAME}.manage().timeouts().implicitlyWait(${Globals.forcedTimeout()}, java.util.concurrent.TimeUnit.MILLISECONDS);"""
		].collect { it.toString() }.join()
	}

	@Override
	def instanceVariables() {
		"org.openqa.selenium.WebDriver ${DRIVER_VAR_NAME};".toString()
	}
}
