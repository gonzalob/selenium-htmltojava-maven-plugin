package dridco.seleniumhtmltojava.commands

class StoreText extends AbstractCommandTest {

	@Override
	protected Object htmlInstructions() {
		"""
<tr>
        <td>storeText</td>
        <td>//div[@class='filter'][1]/a[@class='f'][1]</td>
        <td>storedText</td>
</tr>
"""
	}

	@Override
	protected Object expectedResult() {
		'storage.put("storedText", selenium.getText("//div[@class=\'filter\'][1]/a[@class=\'f\'][1]"));'
	}
}
