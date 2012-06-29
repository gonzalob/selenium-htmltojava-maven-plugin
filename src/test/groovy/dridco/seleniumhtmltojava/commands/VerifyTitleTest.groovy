package dridco.seleniumhtmltojava.commands

class VerifyTitleTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>verifyTitle</td>
        <td>The Title</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'assertThat(\"verifyTitle(\\\"The Title\\\", \\\"\\\")\", selenium.getTitle(), containsString("The Title"));'
	}
}
