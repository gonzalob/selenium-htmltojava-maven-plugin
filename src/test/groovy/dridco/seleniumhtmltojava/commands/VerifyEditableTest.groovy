package dridco.seleniumhtmltojava.commands

class VerifyEditableTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyEditable</td>
	<td>some_element</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertTrue("verifyEditable(\\\"some_element\\\", \\\"\\\")", selenium.isEditable("some_element"));'
	}
}
