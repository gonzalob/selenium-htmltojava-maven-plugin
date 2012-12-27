package dridco.seleniumhtmltojava.commands

class VerifyNotEditableTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyNotEditable</td>
	<td>a_locator</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertFalse("verifyNotEditable(\\\"a_locator\\\", \\\"\\\")", selenium.isEditable("a_locator"));'
	}
}
