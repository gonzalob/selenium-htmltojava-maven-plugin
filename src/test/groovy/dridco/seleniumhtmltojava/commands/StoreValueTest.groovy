package dridco.seleniumhtmltojava.commands

class StoreValueTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>storeValue</td>
        <td>id=foo</td>
        <td>theName</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'storage.put("theName", selenium.getValue("id=foo"));'
	}
}
