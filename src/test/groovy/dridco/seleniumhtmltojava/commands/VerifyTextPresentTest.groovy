package dridco.seleniumhtmltojava.commands

class VerifyTextPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>verifyTextPresent</td>
		<td>Some Text</td>
		<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"assertTrue(\"verifyTextPresent(\\\"Some Text\\\", \\\"\\\")\", selenium.isTextPresent(\"Some Text\"));"
	}
}
