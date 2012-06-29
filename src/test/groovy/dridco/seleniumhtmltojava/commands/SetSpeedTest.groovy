package dridco.seleniumhtmltojava.commands

class SetSpeedTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>setSpeed</td>
        <td>50</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.setSpeed("50");'
	}
}
