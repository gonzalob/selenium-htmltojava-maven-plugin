package dridco.seleniumhtmltojava;

import static dridco.seleniumhtmltojava.TestVariables.SELENIUM;

/**
 * An enumeration of functions available for commands to invoke
 */
public enum Functions {

	pause {
		@Override
		public String render() {
			return "private void pause(int millis) {"
					+ "try { Thread.sleep(millis); }"
					+ "catch (InterruptedException e) { fail(e.getMessage()); }"
					+ "}";
		}
	},
	waitForPageToLoad {
		@Override
		public String render() {
			return "private void waitForPageToLoad(String timeout) {"
					+ "int millis = Integer.valueOf(timeout);"
					+ "int actualTimeout;"
					+ "if(" + Globals.forcedTimeout + " > 0) { actualTimeout = " + Globals.forcedTimeout + "; }"
					+ "else { actualTimeout = millis; }"
					+ "long start = System.currentTimeMillis();"
					+ "selenium.waitForPageToLoad(\"\" + actualTimeout);"
					+ "long duration = System.currentTimeMillis() - start;"
					+ "if(duration > millis) { logger.warning(java.text.MessageFormat.format(\"Defined timeout insufficient. Declared: {0}, Forced: {1}, Actual: {2}\", millis, " + Globals.forcedTimeout + ", duration)); }" 
					+ "}";
		}
	},
	waitForElementPresent {
		@Override
		public String render() {
			return waitForSomething(new WaitCallback(this) {

				public String waitCondition() {
					return SELENIUM + ".isElementPresent(element)";
				}

			});
		}
	},
	waitForTextPresent {
		@Override
		public String render() {
			return waitForSomething(new WaitCallback(this) {
				
				public String waitCondition() {
					return SELENIUM + ".isTextPresent(element)";
				}
				
			});
		}
	},
	waitForEditable {
		@Override
		public String render() {
			return waitForSomething(new WaitCallback(this) {

				public String waitCondition() {
					return SELENIUM + ".isEditable(element)";
				}

			});
		}
	};

	public abstract String render();

	private abstract class WaitCallback {

		private final Functions function;

		public WaitCallback(Functions function) {
			this.function = function;
		}

		private String methodName() {
			return function.name();
		}

		abstract String waitCondition();
	}

	protected String waitForSomething(WaitCallback callback) {
		return "private void " + callback.methodName() + "(String element, String timeout) {"
				+ "int millis = Integer.valueOf(timeout);"
				+ "final int millisBetweenAttempts = 500;"
				+ "int remainingAttempts = millis / millisBetweenAttempts;"
				+ "while (remainingAttempts > 0) {"
				+ "if(" + callback.waitCondition() + ") { break; }"
				+ "else { remainingAttempts--; try { Thread.sleep(millisBetweenAttempts); } catch (InterruptedException e) { fail(e.getMessage()); } }"
				+ "}}";
	}

}
