package dridco.seleniumhtmltojava.commands

class StoreLocationTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>storeLocation</td>
        <td>URL</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'storage.put("URL", selenium.getLocation());'
	}
}
