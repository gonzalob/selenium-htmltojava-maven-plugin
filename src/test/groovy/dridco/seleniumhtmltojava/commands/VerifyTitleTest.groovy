package dridco.seleniumhtmltojava.commands

class VerifyTitleTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>verifyTitle</td>
        <td>The Title</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertThat(\"verifyTitle(\\\"The Title\\\", \\\"\\\")\", selenium.getTitle(), containsString("The Title"));'
	}
}
