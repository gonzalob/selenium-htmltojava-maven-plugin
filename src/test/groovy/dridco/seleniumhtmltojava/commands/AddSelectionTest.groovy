package dridco.seleniumhtmltojava.commands

class AddSelectionTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>addSelection</td>
        <td>id=anId</td>
        <td>label=Foo</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.addSelection("id=anId", "label=Foo");'
	}
}
