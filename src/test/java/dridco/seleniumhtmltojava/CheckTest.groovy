package dridco.seleniumhtmltojava.commands

class CheckTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>check</td>
	<td>id=an_id</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.check("id=an_id");'
	}

}
