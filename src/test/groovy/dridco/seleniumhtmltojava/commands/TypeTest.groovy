package dridco.seleniumhtmltojava.commands

class TypeTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>type</td>
		<td>id=email</td>
		<td>foo@bar.com</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.type("id=email", "foo@bar.com");'
	}
}
