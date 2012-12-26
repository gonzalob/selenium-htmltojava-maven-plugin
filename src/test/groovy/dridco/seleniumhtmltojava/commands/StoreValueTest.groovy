package dridco.seleniumhtmltojava.commands

class StoreValueTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>storeValue</td>
        <td>id=foo</td>
        <td>theName</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("theName", escapeJavaScript(selenium.getValue("id=foo")));'
	}
}
