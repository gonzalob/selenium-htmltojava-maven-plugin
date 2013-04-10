package dridco.seleniumhtmltojava.commands

class StoreTextTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>storeText</td>
        <td>//div[@class='filter'][1]/a[@class='f'][1]</td>
        <td>storedText</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("storedText", selenium.getText("//div[@class=\'filter\'][1]/a[@class=\'f\'][1]"));'
	}
}
