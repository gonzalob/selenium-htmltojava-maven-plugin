package dridco.seleniumhtmltojava.commands

class AssertTextPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>assertTextPresent</td>
        <td>Blah</td>
        <td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertTrue(\"verifyTextPresent(\\\"Blah\\\", \\\"\\\")\", selenium.isTextPresent("Blah"));'
	}
}
