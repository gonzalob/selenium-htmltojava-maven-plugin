package dridco.seleniumhtmltojava.commands

class RemoveSelectionTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>removeSelection</td>
        <td>id=sel</td>
        <td>label=123</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.removeSelection("id=sel", "label=123");'
	}
}
