package dridco.seleniumhtmltojava.commands

class SelectTest extends AbstractCommandTest{

	@Override
	def protected htmlInstructions() {
		"""
<tr>
		<td>select</td>
		<td>id=an_id</td>
		<td>label=Some Text</td>
</tr>
"""
	}

	@Override
	def protected expectedResult() {
		'selenium.select("id=an_id", "label=Some Text");'
	}
}
