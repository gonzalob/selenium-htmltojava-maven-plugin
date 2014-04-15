package dridco.seleniumhtmltojava.commands

class StoreTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>store</td>
        <td>123456</td>
        <td>hardcoded</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("hardcoded", "123456");'
	}
}
