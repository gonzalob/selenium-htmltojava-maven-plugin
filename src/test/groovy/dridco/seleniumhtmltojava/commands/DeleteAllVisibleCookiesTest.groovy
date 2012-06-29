package dridco.seleniumhtmltojava.commands

class DeleteAllVisibleCookiesTest extends AbstractCommandTest {


	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>deleteAllVisibleCookies</td>
		<td></td>
		<td>path=/sample,domain=localhost</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.deleteAllVisibleCookies();'
	}
}
