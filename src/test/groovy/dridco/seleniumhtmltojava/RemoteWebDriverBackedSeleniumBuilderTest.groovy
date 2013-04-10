package dridco.seleniumhtmltojava

import static org.junit.Assert.assertEquals

import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test

class RemoteWebDriverBackedSeleniumBuilderTest {

	@Test void rendersWithoutPreferencesOrProfileSettings() {
		def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
		def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
org.openqa.selenium.remote.RemoteWebDriver driver = new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom);
selenium = new org.openqa.selenium.WebDriverBackedSelenium(driver, "localhost")"""
		assertEquals expected, tested.build()
	}

	@Test void rendersBooleanCapabilities() {
		def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
		tested.capabilities["boolean"] = true
		def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);capabilities.put("boolean", true);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
org.openqa.selenium.remote.RemoteWebDriver driver = new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom);
selenium = new org.openqa.selenium.WebDriverBackedSelenium(driver, "localhost")"""
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
org.openqa.selenium.remote.RemoteWebDriver driver = new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom);
selenium = new org.openqa.selenium.WebDriverBackedSelenium(driver, "localhost")"""
		assertEquals expected, tested.build()
	}

	@Test void startIsNoOp() {
		def WHATEVER
		assertEquals "selenium.setSpeed(\"0\");selenium.setTimeout(\"30000\");driver.manage().timeouts().implicitlyWait(-1, java.util.concurrent.TimeUnit.MILLISECONDS);",
				new RemoteWebDriverBackedSeleniumBuilder(WHATEVER, WHATEVER, WHATEVER, WHATEVER).start()
	}
	
	@Test
	void rendersDefinedTimeout() {
		def forcedTimeout = 300000
		def template = new CustomGlobalsTemplate()
		template.with {
			setForcedTimeout(forcedTimeout)
			execute(new CustomGlobalsCallback() {

				@Override
				public void execute() {
					def tested = new RemoteWebDriverBackedSeleniumBuilder("localhost", 4444, "firefox", "localhost")
					def expected = """
org.openqa.selenium.firefox.FirefoxProfile profile = new org.openqa.selenium.firefox.FirefoxProfile();
java.util.HashMap capabilities = new java.util.HashMap(); capabilities.put("firefox_profile", profile);
org.openqa.selenium.remote.DesiredCapabilities firefox = org.openqa.selenium.remote.DesiredCapabilities.firefox(); org.openqa.selenium.remote.DesiredCapabilities custom = new org.openqa.selenium.remote.DesiredCapabilities(capabilities); custom.merge(firefox);
org.openqa.selenium.remote.RemoteWebDriver driver = new org.openqa.selenium.remote.RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), custom);
selenium = new org.openqa.selenium.WebDriverBackedSelenium(driver, "localhost")"""
					assertEquals expected, tested.build()
				}
			})
		}
	}
}
