package dridco.seleniumhtmltojava.commands

class StoreAttributeTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>storeAttribute</td>
		<td>//div[@id=\'foo\']</td>
		<td>identifier</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("identifier", selenium.getValue("//div[@id=\'foo\']"));'
	}
}
