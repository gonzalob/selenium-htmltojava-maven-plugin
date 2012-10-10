package dridco.seleniumhtmltojava.commands

// http://www.codediesel.com/testing/selenium-ide-pattern-matching/
class VerifyEvalGlobAsteriskTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyEval</td>
	<td>'a' + 'b';</td>
	<td>glob:\${one}*two</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"assertTrue(\"verifyEval(\\\"'a' + 'b';\\\", \\\"glob:\" + storage.get(\"one\") + \"*two\\\")\", selenium.getEval(\"'a' + 'b';\").matches((\"^\\\\Q\" + \"\" + storage.get(\"one\") + \"*two\" + \"\\\\E\$\").replaceAll(\"*\", \"\\\\E.*\\\\Q\").replaceAll(\"?\", \"\\\\E.\\\\Q\")));"
	}
}
