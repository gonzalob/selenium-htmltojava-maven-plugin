package dridco.seleniumhtmltojava.commands

class DeleteAllVisibleCookiesTest extends AbstractCommandTest {


	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>deleteAllVisibleCookies</td>
		<td></td>
		<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.deleteAllVisibleCookies();'
	}
}
