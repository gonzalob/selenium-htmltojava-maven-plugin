package dridco.seleniumhtmltojava.commands

class SetTimeoutTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>setTimeout</td>
        <td>100000</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.setTimeout("100000");'
	}
}
