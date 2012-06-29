package dridco.seleniumhtmltojava.commands

class WaitForTextPresentTest extends AbstractCommandTest {

	@Override
	protected Object htmlInstructions() {
		return """
<tr>
        <td>waitForTextPresent</td>
        <td>a text.</td>
        <td></td>
</tr>
""";
	}

	@Override
	protected Object expectedResult() {
		return 'waitForTextPresent("a text.", "30000");';
	}

}
