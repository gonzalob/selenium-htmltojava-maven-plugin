package dridco.seleniumhtmltojava.commands

class SetTimeoutTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>setTimeout</td>
        <td>100000</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.setTimeout("100000");'
	}
}
