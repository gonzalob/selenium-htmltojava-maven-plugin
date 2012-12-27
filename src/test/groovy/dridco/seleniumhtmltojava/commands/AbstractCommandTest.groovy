package dridco.seleniumhtmltojava.commands

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

import javax.tools.JavaCompiler
import javax.tools.JavaFileObject
import javax.tools.ToolProvider
import javax.tools.JavaCompiler.CompilationTask

import junit.framework.Assert

import org.apache.commons.logging.LogFactory
import org.junit.Test

abstract class AbstractCommandTest {

	def logger

	public AbstractCommandTest() {
		logger = LogFactory.getLog(getClass())
	}

	@Test void canParseCommand() {
		assertThat compileInstructions(), containsString(expectedResult())
	}

	@Test void canCompile() {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		JavaFileObject file = new JavaSourceFromString("_SomeTestITCase", compileInstructions());
		CompilationTask task = compiler.getTask(null, null, null, null, null, Arrays.asList(file));

		Assert.assertTrue(task.call());
	}

	def compileInstructions() {
		def script = new ScriptBuilder()
		script.commands << htmlInstructions()
		script.compile()
	}

	def protected abstract htmlInstructions()

	def protected abstract expectedResult()
}
