package dridco.seleniumhtmltojava

final class SeleniumBuilder {

	private final String serverHost
	private final Integer serverPort
	private final SupportedBrowsers browser
	private final String baseUrl

	public SeleniumBuilder(
	final String serverHost,
	final Integer serverPort,
	final SupportedBrowsers browser,
	final String baseUrl) {
		this.serverHost = serverHost
		this.serverPort = serverPort
		this.browser = browser
		this.baseUrl = baseUrl
	}

	public String build(final String base) {
		return String.format(
		"new com.thoughtworks.selenium.DefaultSelenium(\"%s\", %d, \"*%s\", \"%s\");",
		serverHost, serverPort, browser, base ?: baseUrl)
	}
}