package dridco.seleniumhtmltojava.commands

class WaitForTextPresentTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
        <td>waitForTextPresent</td>
        <td>a text.</td>
        <td></td>
</tr>
""";
	}

	@Override
	def expectedResult() {
		'waitForTextPresent("a text.", "30000");';
	}
}
