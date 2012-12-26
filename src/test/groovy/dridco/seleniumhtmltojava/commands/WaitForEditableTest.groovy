package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*


class WaitForEditableTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>waitForEditable</td>
        <td>//input[@id='sample']</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"""waitForEditable("//input[@id='sample']", "30000");"""
	}
}
