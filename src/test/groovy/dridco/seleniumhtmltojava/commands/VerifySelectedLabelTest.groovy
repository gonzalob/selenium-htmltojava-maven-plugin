package dridco.seleniumhtmltojava.commands

class VerifySelectedLabelTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifySelectedLabel</td>
	<td>some_id</td>
	<td>A label in a combo</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		/assertEquals("A label in a combo", selenium.getSelectedLabel("some_id"));/
	}

}
