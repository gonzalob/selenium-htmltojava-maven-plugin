package dridco.seleniumhtmltojava.commands

class SelectWindowTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>selectWindow</td>
        <td>null</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.selectWindow("null");'
	}
}
