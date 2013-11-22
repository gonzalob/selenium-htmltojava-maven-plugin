package dridco.seleniumhtmltojava.commands

class VerifyExpressionTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>verifyExpression</td>
        <td>\${source}</td>
        <td>\${target}</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertThat(\"verifyExpression(\\\"" + storage.get("source") + "\\\", \\\"" + storage.get("target") + "\\\")\", selenium.getExpression("" + storage.get("source") + ""), containsString("" + storage.get("target") + ""));'
	}
}
