package dridco.seleniumhtmltojava.commands;

import static org.junit.Assert.*;

class WaitForNotValueTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		return """
<tr>
        <td>waitForNotValue</td>
        <td>id="foo"</td>
        <td>10</td>
</tr>
""";
	}

	@Override
	def protected expectedResult() {
		return "waitForNotValue(\"id=\\\"foo\\\"\", \"10\");";
	}

}
