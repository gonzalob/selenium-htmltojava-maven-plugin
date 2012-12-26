package dridco.seleniumhtmltojava.commands

class SetSpeedTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>setSpeed</td>
        <td>50</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.setSpeed("50");'
	}
}
