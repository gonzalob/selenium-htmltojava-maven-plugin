package dridco.seleniumhtmltojava.commands

class PauseTest extends AbstractCommandTest{

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>pause</td>
		<td>2000</td>
		<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'pause(2000);'
	}
}
