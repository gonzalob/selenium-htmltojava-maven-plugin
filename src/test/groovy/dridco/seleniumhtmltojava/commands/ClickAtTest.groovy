package dridco.seleniumhtmltojava.commands

class ClickAtTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>clickAt</td>
	<td>id=some_id</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"selenium.clickAt(\"id=some_id\", \"\");"
	}
}
