package dridco.seleniumhtmltojava.commands

class TypeKeysTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>typeKeys</td>
        <td>id=t</td>
        <td>12</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.typeKeys("id=t", "12");'
	}
}
