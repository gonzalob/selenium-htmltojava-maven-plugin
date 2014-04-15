package dridco.seleniumhtmltojava.commands

class WaitForElementPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
    <td>waitForElementPresent</td>
    <td>an_element_id</td>
    <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"waitForElementPresent(\"an_element_id\", \"30000\");"
	}
}
