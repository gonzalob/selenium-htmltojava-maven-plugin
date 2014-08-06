package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.collections15.CollectionUtils.collect;
import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.apache.commons.lang.StringUtils.join;

import org.apache.commons.collections15.Transformer;

/**
 * An enumeration of functions available for commands to invoke
 */
public enum Functions {

	pause {
		@Override
		public String render() {
			return functionDeclaration(
					new FunctionParameter[] { //
					new FunctionParameter(PauseFunctionBody.TIMEOUT_PARAMETER_NAME, Integer.class) },
					new PauseFunctionBody());
		}
	},
	waitForPageToLoad {
		@Override
		public String render() {
			return functionDeclaration(
					new FunctionParameter[] { //
					new FunctionParameter(WaitForPageToLoadFunctionBody.TIMEOUT_PARAMETER_NAME, String.class) },
					new WaitForPageToLoadFunctionBody());
		}
	},
	waitForElementPresent {
		@Override
		public String render() {
			return waitForSomething(new WaitForElementPresentFunctionCallback());
		}
	},
	waitForTextPresent {
		@Override
		public String render() {
			return waitForSomething(new WaitForTextPresentFunctionCallback());
		}
	},
	waitForEditable {
		@Override
		public String render() {
			return waitForSomething(new WaitForEditableFunctionCallback());
		}
	},
	waitForNotValue {
		@Override
		public String render() {
			return functionDeclaration(new FunctionParameter[] {
					new FunctionParameter(WaitForNotValueFunctionBody.TARGET_PARAMETER_NAME, String.class),
					new FunctionParameter(WaitForNotValueFunctionBody.VALUE_PARAMETER_NAME, String.class) },
					new WaitForNotValueFunctionBody());
		}
	},
	waitForVisible {
		@Override
		public String render() {
			return waitForSomething(new WaitForVisibleFunctionCallback());
		}
	},
	waitForNotVisible {

		@Override
		public String render() {
			return waitForSomething(new NotFunctionBody(new WaitForVisibleFunctionCallback()));
		}
	},
	open {
		@Override
		public String render() {
			return functionDeclaration(new FunctionParameter[] {
					new FunctionParameter(OpenFunctionBody.URL_PARAMETER, String.class) },
					new OpenFunctionBody());
		}
	},
	waitForSelectedLabel {
		@Override
		public String render() {
			String selectLocator = "selectLocator";
			String pattern = "pattern";
			Object condition = format("%s.equals(%s.getSelectedLabel(%s))", pattern, SELENIUM, selectLocator);
			WaitForFunctionBody body = new WaitForFunctionBody(condition).withTimeout(Globals.timeout());
			return functionDeclaration(new FunctionParameter[] {
					new FunctionParameter(selectLocator, String.class),
					new FunctionParameter(pattern, String.class) },
					body);
		}
	};

	public abstract String render();

	protected String waitForSomething(final WaitForFunctionCallback callback) {
		final String targetArgumentName = "element";
		final String valueArgumentName = WaitForFunctionBody.TIMEOUT_PARAMETER;
		final String waitCondition = callback.waitCondition(targetArgumentName, valueArgumentName);
		return functionDeclaration(new FunctionParameter[] {
				new FunctionParameter(targetArgumentName, String.class),
				new FunctionParameter(valueArgumentName, String.class) },
				new WaitForFunctionBody(waitCondition));
	}

	protected String functionDeclaration(FunctionParameter[] parameters,
			FunctionBody body) {
		Transformer<FunctionParameter, String> parametersForDeclaration = new ParametersForDeclaration();
		String parameterSeparator = ",";
		String parametersDeclaration = join(collect(asList(parameters), parametersForDeclaration), parameterSeparator);
		String functionBody = body.render();
		return format("private void %s(%s) {%s}", name(), parametersDeclaration, functionBody);
	}

	private static final class WaitForFunctionBody implements FunctionBody {

		private static final String TIMEOUT_PARAMETER = "timeout";
		
		private Object waitCondition;

		private String timeoutInitialization ;

		public WaitForFunctionBody(Object waitCondition) {
			this.waitCondition = waitCondition;
			timeoutInitialization = EMPTY;
		}

		/**
		 * Initializes the {@value #TIMEOUT_PARAMETER} variable with the specified value<br>
		 * Keep in mind that functions using the body rendered by objects after this call cannot 
		 * expect to receive a {@value #TIMEOUT_PARAMETER} argument, as the compiler will complain.
		 */
		public WaitForFunctionBody withTimeout(Object timeout) {
			timeoutInitialization = String.format("String %s = \"%s\";", TIMEOUT_PARAMETER, timeout); 
			return this;
		}

		@Override
		public String render() {
			return format(
				"" + timeoutInitialization 
						+ "int millis = Integer.valueOf(" + TIMEOUT_PARAMETER + ");"
						+ "if(" + Globals.forcedTimeout() + " > millis) { millis = " + Globals.forcedTimeout() + "; }"
						+ "final int millisBetweenAttempts = 500;"
						+ "int remainingAttempts = millis / millisBetweenAttempts;"
						+ "boolean success = false;"
						+ "while (remainingAttempts > 0) {"
						+ "if(%s) { success = true; break; }"
						+ "else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }"
						+ "}"
						+ "assertTrue(success);", //
						waitCondition);
		}
		
	}
	
	private static final class ParametersForDeclaration implements Transformer<FunctionParameter, String> {
		
		public String transform(FunctionParameter input) { return input.renderForDeclaration(); }
		
	}

}
