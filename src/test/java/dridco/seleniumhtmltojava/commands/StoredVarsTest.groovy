package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import dridco.seleniumhtmltojava.JavaTestCompiler
import dridco.seleniumhtmltojava.SeleniumBuilderFixture
import dridco.seleniumhtmltojava.commands.ScriptBuilder

class StoredVarsTest {

	def compiled

	@Before void compileJavaSource() {
		def script = new ScriptBuilder()
		script.commands << """
<tr>
	<td>storeEval</td>
	<td>var a = ((storedVars['source']).indexOf('a')) + 1;</td>
	<td>target</td>
</tr>
"""
		script.commands << """
<tr>
		<td>echo</td>
		<td>\${FechaFinalizacionScript}</td>
		<td></td>
</tr>
"""
		compiled = script.compile()
	}

	@Test void canUseStoredValues() {
		assertThat compiled, containsString('storage.get("FechaFinalizacionScript")')
	}
	@Test void canParseStoredVars() {
		assertThat compiled, containsString('storage.put("target", selenium.getEval("var a = ((\\\"" + storage.get("source") + "\\\").indexOf(\'a\')) + 1;"));')
	}
}
