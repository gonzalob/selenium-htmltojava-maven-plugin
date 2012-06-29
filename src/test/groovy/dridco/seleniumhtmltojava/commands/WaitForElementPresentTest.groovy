package dridco.seleniumhtmltojava.commands

class WaitForElementPresentTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
    <td>waitForElementPresent</td>
    <td>an_element_id</td>
    <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		"waitForElementPresent(\"an_element_id\", \"30000\");"
	}
}
