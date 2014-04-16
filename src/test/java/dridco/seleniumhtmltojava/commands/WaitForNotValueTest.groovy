package dridco.seleniumhtmltojava.commands;

import static org.junit.Assert.*;

class WaitForNotValueTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>waitForNotValue</td>
        <td>id="foo"</td>
        <td>10</td>
</tr>
""";
	}

	@Override
	def expectedResult() {
		"waitForNotValue(\"id=\\\"foo\\\"\", \"10\");";
	}

}
