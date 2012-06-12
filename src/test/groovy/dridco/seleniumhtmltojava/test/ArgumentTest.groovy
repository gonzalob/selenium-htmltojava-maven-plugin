package dridco.seleniumhtmltojava.test

import static org.junit.Assert.assertEquals

import dridco.seleniumhtmltojava.Argument
import org.junit.Test

class ArgumentTest {

	@Test void canParseDoubleQuotes() {
		Argument tested = new Argument("id=\"foo\"")
		assertEquals "id=\\\"foo\\\"", tested.parse()
	}

	@Test void canParseStoredVars() {
		def tested = new Argument("storedVars['name'].replace(/\\./g,'');").parse()
		assertEquals "\\\"\" + storage.get(\"name\") + \"\\\".replace(/\\\\./g,'');", tested
	}

	@Test void doesNotMessWithStoredVars() {
		def tested = new Argument('storage.get("FechaFinalizacionScript")').parse()
		assertEquals 'storage.get("FechaFinalizacionScript")', tested
	}

	@Test void canParseSeveralStoredVars() {
		def tested = new Argument('var a = (storedVars[\'_1\']).substring((storedVars[\'_2\']),(storedVars[\'_3\']))').parse()
		assertEquals 'var a = (\\\"\" + storage.get(\"_1\") + \"\\\").substring((\\\"\" + storage.get(\"_2\") + \"\\\"),(\\\"\" + storage.get(\"_3\") + \"\\\"))', tested
	}
}
