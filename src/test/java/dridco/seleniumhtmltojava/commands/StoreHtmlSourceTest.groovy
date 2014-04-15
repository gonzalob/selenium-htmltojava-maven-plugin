package dridco.seleniumhtmltojava.commands

class StoreHtmlSourceTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>storeHtmlSource</td>
	<td>aVariable</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"storage.put(\"aVariable\", escapeJavaScript(selenium.getHtmlSource()));"
	}
}
