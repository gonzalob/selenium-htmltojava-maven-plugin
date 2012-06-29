package dridco.seleniumhtmltojava.commands

class SelectFrameTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>selectFrame</td>
        <td>relative=up</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.selectFrame("relative=up");'
	}
}
