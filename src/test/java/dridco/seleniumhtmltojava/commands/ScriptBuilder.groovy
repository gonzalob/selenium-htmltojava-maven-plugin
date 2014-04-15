package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import org.apache.commons.io.output.NullWriter;
import org.junit.rules.TestName

import dridco.seleniumhtmltojava.JavaTestCompiler
import dridco.seleniumhtmltojava.SeleniumBuilderFixture

public class ScriptBuilder {

	def private DEFAULT_TEST_NAME = "SomeTest"

	def commands = []
	def testName = DEFAULT_TEST_NAME

	def compile() {
		JavaTestCompiler compiler = new JavaTestCompiler(SeleniumBuilderFixture.BUILDER)
		compiler.compile(
"""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head profile="http://selenium-ide.openqa.org/profiles/test-case">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="selenium.base" href="http://localhost/" />
<title>Some Title</title>
</head>
<body>
<table cellpadding="1" cellspacing="1" border="1">
<thead>
<tr><td rowspan="1" colspan="3">Some Name</td></tr>
</thead><tbody>
	${commands}
</tbody></table>
	</body>
</html>""", testName)
	}
}
