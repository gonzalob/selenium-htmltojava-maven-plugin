package dridco.seleniumhtmltojava;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.collections15.CollectionUtils.collect;
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
					new FunctionParameter("millis", Integer.class) },
					new PauseFunctionBody());
		}
	},
	waitForPageToLoad {
		@Override
		public String render() {
			return functionDeclaration(
					new FunctionParameter[] { //
					new FunctionParameter("timeout", String.class) },
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
					new FunctionParameter("target", String.class),
					new FunctionParameter("value", String.class) },
					new WaitForNotValueFunctionBody());
		}
	};

	public abstract String render();

	protected String waitForSomething(final WaitForFunctionCallback callback) {
		final String targetArgumentName = "element";
		final String valueArgumentName = "timeout";
		return functionDeclaration(new FunctionParameter[] {
				new FunctionParameter(targetArgumentName, String.class),
				new FunctionParameter(valueArgumentName, String.class) },
				new FunctionBody() {

					public String render() {
						return format(
								"int millis = Integer.valueOf(timeout);"
										+ "final int millisBetweenAttempts = 500;"
										+ "int remainingAttempts = millis / millisBetweenAttempts;"
										+ "while (remainingAttempts > 0) {"
										+ "if(%s) { break; }"
										+ "else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }"
										+ "}", //
								callback.waitCondition(targetArgumentName,
										valueArgumentName));
					}
				});
	}

	protected String functionDeclaration(FunctionParameter[] parameters,
			FunctionBody body) {
		Transformer<FunctionParameter, String> parametersForDeclaration = new Transformer<FunctionParameter, String>() {

			public String transform(FunctionParameter input) {
				return input.renderForDeclaration();
			}
		};
		String parameterSeparator = ",";
		String parametersDeclaration = //
		join(collect(asList(parameters), parametersForDeclaration),
				parameterSeparator);
		String functionBody = body.render();
		return format("private void %s(%s) {%s}", //
				name(), parametersDeclaration, functionBody);
	}

}
