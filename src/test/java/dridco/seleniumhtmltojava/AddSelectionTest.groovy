package dridco.seleniumhtmltojava.commands

class AddSelectionTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>addSelection</td>
        <td>id=anId</td>
        <td>label=Foo</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.addSelection("id=anId", "label=Foo");'
	}
}
