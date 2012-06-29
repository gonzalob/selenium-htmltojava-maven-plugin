package dridco.seleniumhtmltojava.commands

class AssertTextPresentTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
        <td>assertTextPresent</td>
        <td>Blah</td>
        <td></td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'assertTrue(\"verifyTextPresent(\\\"Blah\\\", \\\"\\\")\", selenium.isTextPresent("Blah"));'
	}
}
