package dridco.seleniumhtmltojava.commands;

public class VerifyNotCheckedTest extends AbstractCommandTest {

	def htmlInstructions() {
		"""
<tr>
	<td>verifyNotChecked</td>
	<td>id=an_id</td>
	<td></td>
</tr>
"""
	}

	def expectedResult() {
		'assertFalse("verifyNotChecked(\\\"id=an_id\\\", \\\"\\\")", selenium.isChecked("id=an_id"));'
	}
}
