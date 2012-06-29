package dridco.seleniumhtmltojava.commands

class ClickTest  extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>click</td>
		<td>id="an_input"</td>
		<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.click("id=\\"an_input\\"");'
	}
}
