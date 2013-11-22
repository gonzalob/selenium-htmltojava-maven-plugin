package dridco.seleniumhtmltojava.commands

class EchoTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>echo</td>
		<td>\${FechaFinalizacionScript}</td>
		<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"logger.info(\"\" + storage.get(\"FechaFinalizacionScript\") + \"\");"
	}
}
