package dridco.seleniumhtmltojava.commands

class StoreLocationTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>storeLocation</td>
        <td>URL</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("URL", selenium.getLocation());'
	}
}
