package dridco.seleniumhtmltojava.commands

class VerifyTextNotPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>verifyTextNotPresent</td>
		<td>Some Text</td>
		<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"assertFalse(\"verifyTextNotPresent(\\\"Some Text\\\", \\\"\\\")\", selenium.isTextPresent(\"Some Text\"));"
	}
}
