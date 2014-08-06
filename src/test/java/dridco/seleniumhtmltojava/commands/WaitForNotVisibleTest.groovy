package dridco.seleniumhtmltojava.commands

class WaitForNotVisibleTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>waitForNotVisible</td>
        <td>id="hidden"</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'waitForNotVisible("id=\\"hidden\\"", "30000");'
	}
}
