package dridco.seleniumhtmltojava.commands

class ClickAndWaitTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>clickAndWait</td>
        <td>link=Some link</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'selenium.click("link=Some link");waitForPageToLoad("30000");'
	}
}
