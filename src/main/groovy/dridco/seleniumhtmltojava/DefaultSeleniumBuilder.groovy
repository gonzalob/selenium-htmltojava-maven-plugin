package dridco.seleniumhtmltojava

final class DefaultSeleniumBuilder {

	final serverHost
	final serverPort
	final browser
	final baseUrl

	DefaultSeleniumBuilder(host, port, browser, base) {
		serverHost = host
		serverPort = port
		this.browser = browser
		baseUrl = base
	}

	public String build(final String base) {
		String.format(
				"new com.thoughtworks.selenium.DefaultSelenium(\"%s\", %d, \"%s\", \"%s\");",
				serverHost, serverPort, browser, base ?: baseUrl)
	}
}
