package dridco.seleniumhtmltojava.commands

class AssertConfirmationTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>assertConfirmation</td>
        <td>Do something?</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'assertEquals(\"assertConfirmation(\\\"Do something?\\\", \\\"\\\")\", "Do something?", selenium.getConfirmation());'
	}
}
