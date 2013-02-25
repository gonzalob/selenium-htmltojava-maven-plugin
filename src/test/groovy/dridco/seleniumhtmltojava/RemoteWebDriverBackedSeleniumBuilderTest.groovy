package dridco.seleniumhtmltojava

import static org.junit.Assert.assertEquals

import org.junit.Test

class RemoteWebDriverBackedSeleniumBuilderTest {

	@Test void rendersWithoutPreferencesOrProfileSettings() {
		def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
		def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
new org.openqa.selenium.WebDriverBackedSelenium(new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom), "localhost")"""
		assertEquals expected, tested.build()
	}

	@Test void rendersBooleanCapabilities() {
		def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
		tested.capabilities["boolean"] = true
		def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);capabilities.put("boolean", true);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
new org.openqa.selenium.WebDriverBackedSelenium(new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom), "localhost")"""
		assertEquals expected, tested.build()
	}

	@Test void rendersProfileSettings() {
		def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
		tested.preferences["boolean"] = true
		tested.preferences["numeric"] = 8080
		tested.preferences["string"] = "\"localhost\""
		def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();profile.setPreference("boolean", true);profile.setPreference("numeric", 8080);profile.setPreference("string", "localhost");
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
new org.openqa.selenium.WebDriverBackedSelenium(new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom), "localhost")"""
		assertEquals expected, tested.build()
	}

	@Test void startIsNoOp() {
		def WHATEVER
		assertEquals "", new RemoteWebDriverBackedSeleniumBuilder(WHATEVER, WHATEVER, WHATEVER, WHATEVER).start()
	}
}
