package dridco.seleniumhtmltojava.commands

class StoreEvalTest extends AbstractCommandTest {

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>storeEval</td>
		<td>var a = "";</td>
		<td>aString</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'storage.put("aString", selenium.getEval("var a = \\"\\";"));'
	}
}
