package dridco.seleniumhtmltojava.commands

import org.junit.Assert;

class VerifyCheckedTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
	<td>verifyChecked</td>
	<td>locator</td>
	<td></td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'assertTrue("verifyChecked(\\"locator\\", \\"\\")", selenium.isChecked("locator"));'
	}
}
