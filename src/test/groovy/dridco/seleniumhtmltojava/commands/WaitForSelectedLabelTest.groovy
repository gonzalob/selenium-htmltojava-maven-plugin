package dridco.seleniumhtmltojava.commands

class WaitForSelectedLabelTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>waitForSelectedLabel</td>
		<td>selectLocator</td>
		<td>pattern</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"waitForSelectedLabel(\"selectLocator\", \"pattern\");"
	}
}
