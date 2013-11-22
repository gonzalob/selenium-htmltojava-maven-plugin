package dridco.seleniumhtmltojava.commands

class VerifyValueTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>verifyValue</td>
        <td>//input[@id='someId']</td>
        <td>\${value}</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertThat(\"verifyValue(\\\"//input[@id=\'someId\']\\\", \\\"" + storage.get("value") + "\\\")\", selenium.getValue("//input[@id=\'someId\']"), containsString("" + storage.get("value") + ""));'
	}
}
