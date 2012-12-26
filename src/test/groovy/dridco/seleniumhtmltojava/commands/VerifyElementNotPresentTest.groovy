package dridco.seleniumhtmltojava.commands

class VerifyElementNotPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>verifyElementNotPresent</td>
        <td>//a[text()='aValue']</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertFalse(\"verifyElementNotPresent(\\\"//a[text()=\'aValue\']\\\", \\\"\\\")\", selenium.isElementPresent("//a[text()=\'aValue\']"));'
	}
}
