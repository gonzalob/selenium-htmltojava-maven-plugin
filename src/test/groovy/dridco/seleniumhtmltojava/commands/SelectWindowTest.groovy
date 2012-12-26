package dridco.seleniumhtmltojava.commands

class SelectWindowTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>selectWindow</td>
        <td>null</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.selectWindow("null");'
	}
}
