package dridco.seleniumhtmltojava.commands

class VerifyVisibleTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyVisible</td>
	<td>id=an_id</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertTrue("verifyVisible(\\"id=an_id\\", \\"\\")", selenium.isVisible("id=an_id"));'
	}
}
