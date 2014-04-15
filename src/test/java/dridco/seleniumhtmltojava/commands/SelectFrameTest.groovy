package dridco.seleniumhtmltojava.commands

class SelectFrameTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>selectFrame</td>
        <td>relative=up</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.selectFrame("relative=up");'
	}
}
