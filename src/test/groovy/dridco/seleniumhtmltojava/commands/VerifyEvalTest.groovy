package dridco.seleniumhtmltojava.commands

class VerifyEvalTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>verifyEval</td>
        <td>'\${something}'.replace('foo','').trim()</td>
        <td>\${other thing}</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		"assertTrue(\"verifyEval(\\\"\'\" + storage.get(\"something\") + \"\'.replace(\'foo\','').trim()\\\", \\\"\" + storage.get(\"other thing\") + \"\\\")\", selenium.getEval(\"\'\" + storage.get(\"something\") + \"\'.replace(\'foo\','').trim()\").matches(java.util.regex.Pattern.quote(\"\" + storage.get(\"other thing\") + \"\")));"
	}
}
