package dridco.seleniumhtmltojava.commands

class VerifyNotVisibleTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyNotVisible</td>
	<td>id=an_id</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertFalse("verifyNotVisible(\\"id=an_id\\", \\"\\")", selenium.isVisible("id=an_id"));'
	}
}
