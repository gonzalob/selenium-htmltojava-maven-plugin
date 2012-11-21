package dridco.seleniumhtmltojava.commands

class RefreshTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
	<td>refresh</td>
	<td></td>
	<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.refresh();'
	}
}
