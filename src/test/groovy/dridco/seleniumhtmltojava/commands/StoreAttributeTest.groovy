package dridco.seleniumhtmltojava.commands

class StoreAttributeTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>storeAttribute</td>
		<td>//div[@id=\'foo\']</td>
		<td>identifier</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'storage.put("identifier", selenium.getValue("//div[@id=\'foo\']"));'
	}
}
