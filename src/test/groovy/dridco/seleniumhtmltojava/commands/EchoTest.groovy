package dridco.seleniumhtmltojava.commands

class EchoTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>echo</td>
		<td>\${FechaFinalizacionScript}</td>
		<td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		"echo "
	}
}
