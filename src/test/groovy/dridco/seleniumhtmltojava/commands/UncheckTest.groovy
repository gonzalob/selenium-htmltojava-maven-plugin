package dridco.seleniumhtmltojava.commands

class UncheckTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>uncheck</td>
	<td>locator</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.uncheck("locator");'
	}
}
