package dridco.seleniumhtmltojava.commands

class VerifyTextNotPresentTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>verifyTextNotPresent</td>
		<td>Some Text</td>
		<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		"assertFalse(\"verifyTextNotPresent(\\\"Some Text\\\", \\\"\\\")\", selenium.isTextPresent(\"Some Text\"));"
	}
}
