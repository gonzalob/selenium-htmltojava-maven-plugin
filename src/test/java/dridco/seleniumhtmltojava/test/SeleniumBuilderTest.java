package dridco.seleniumhtmltojava.test;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dridco.seleniumhtmltojava.SeleniumBuilder;

public class SeleniumBuilderTest {

	@Test
	public void rendersTheBuilderWithExpectedParameters() {
		SeleniumBuilder tested = new SeleniumBuilder("localhost", 4444, "*firefox", "http://localhost");
		assertEquals(
				"new com.thoughtworks.selenium.DefaultSelenium(\"localhost\", 4444, \"*firefox\", \"http://localhost\");",
				tested.build(EMPTY));
	}

}
