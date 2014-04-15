package dridco.seleniumhtmltojava.commands

class StoreEvalTest extends AbstractCommandTest {

	@Override
	def htmlInstructions() {
		"""
<tr>
		<td>storeEval</td>
		<td>var a = "";</td>
		<td>aString</td>
</tr>
"""
	}

	@Override
	def expectedResult() {
		'storage.put("aString", selenium.getEval("var a = \\"\\";"));'
	}
}
