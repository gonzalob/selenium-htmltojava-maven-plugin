package dridco.seleniumhtmltojava.commands

class VerifyElementPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>verifyElementPresent</td>
		<td>//select[@id='an_id']</td>
		<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"assertTrue(\"verifyElementPresent(\\\"//select[@id=\'an_id\']\\\", \\\"\\\")\", selenium.isElementPresent(\"//select[@id=\'an_id\']\"));"
	}
}
