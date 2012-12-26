package dridco.seleniumhtmltojava.commands

class TypeKeysTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>typeKeys</td>
        <td>id=t</td>
        <td>12</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.typeKeys("id=t", "12");'
	}
}
