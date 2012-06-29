package dridco.seleniumhtmltojava.commands

class StoreHtmlSourceTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
	<td>storeHtmlSource</td>
	<td>aVariable</td>
	<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		"storage.put(\"aVariable\", escapeJavaScript(selenium.getHtmlSource()));"
	}
}
