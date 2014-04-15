package dridco.seleniumhtmltojava.commands

class TypeTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>type</td>
		<td>id=email</td>
		<td>foo@bar.com</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.type("id=email", "foo@bar.com");'
	}
}
