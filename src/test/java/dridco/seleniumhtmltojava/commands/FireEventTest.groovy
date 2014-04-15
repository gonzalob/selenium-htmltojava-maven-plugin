package dridco.seleniumhtmltojava.commands

class FireEventTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
    <td>fireEvent</td>
    <td>some_object</td>
    <td>blur</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"selenium.fireEvent(\"some_object\", \"blur\");"
	}
}
