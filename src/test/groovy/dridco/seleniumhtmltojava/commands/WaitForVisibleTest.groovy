package dridco.seleniumhtmltojava.commands

class WaitForVisibleTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>waitForVisible</td>
        <td>an_element</td>
        <td></td>
</tr>
"""
		
	}

	@Override
	def expectedResult() {
		'waitForVisible("an_element", "30000");';
	}

}
