package dridco.seleniumhtmltojava.test;

import static dridco.seleniumhtmltojava.SupportedBrowsers.firefox;
import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dridco.seleniumhtmltojava.SeleniumBuilder;

public class SeleniumBuilderTest {

	private SeleniumBuilder tested;

	@Before
	public void createTestedObject() {
		tested = new SeleniumBuilder( //
				"localhost", 4444, firefox, "http://localhost");
	}

	@Test
	public void rendersTheBuilderWithExpectedParameters() {
		assertEquals(
				"new com.thoughtworks.selenium.DefaultSelenium(\"localhost\", 4444, \"*firefox\", \"http://localhost\");",
				tested.build(EMPTY));
	}

}
