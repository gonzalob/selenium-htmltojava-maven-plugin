package dridco.seleniumhtmltojava.commands

abstract class AbstractVerifyTextTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyText</td>
	<td>${target()}</td>
	<td>${text()}</td>
</tr>
			"""
	}

	def protected abstract target()
	def protected abstract text()
}
