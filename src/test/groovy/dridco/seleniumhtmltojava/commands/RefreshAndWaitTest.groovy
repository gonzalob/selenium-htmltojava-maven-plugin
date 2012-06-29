package dridco.seleniumhtmltojava.commands

class RefreshAndWaitTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
	<td>refreshAndWait</td>
	<td></td>
	<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.refresh();waitForPageToLoad("30000");'
	}
}
