package dridco.seleniumhtmltojava.commands

class RefreshTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>refresh</td>
	<td></td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.refresh();'
	}
}
