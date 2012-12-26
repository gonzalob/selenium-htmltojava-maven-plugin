package dridco.seleniumhtmltojava.commands

class RefreshAndWaitTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>refreshAndWait</td>
	<td></td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.refresh();waitForPageToLoad("30000");'
	}
}
