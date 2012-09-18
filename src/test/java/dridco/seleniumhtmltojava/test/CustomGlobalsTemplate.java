package dridco.seleniumhtmltojava.test;

import dridco.seleniumhtmltojava.Globals;

class CustomGlobalsTemplate {

	private Integer timeout;
	private Integer speed;
	private Integer forcedTimeout;
	private Integer testTimeout;
	private Boolean verbosity;

	public CustomGlobalsTemplate() {
		timeout = Globals.timeout();
		speed = Globals.speed();
		forcedTimeout = Globals.forcedTimeout();
		testTimeout = Globals.testTimeout();
		verbosity = Globals.verbose();
	}

	public void execute(CustomGlobalsCallback callback) {
		Integer currentTimeout = Globals.timeout();
		Integer currentSpeed = Globals.speed();
		Integer currentForcedTimeout = Globals.forcedTimeout();
		Integer currentTestTimeout = Globals.testTimeout();
		Boolean currentVerbosity = Globals.verbose();
		Globals.define(timeout, speed, forcedTimeout, testTimeout, verbosity);
		callback.execute();
		Globals.define(currentTimeout, currentSpeed, currentForcedTimeout, currentTestTimeout, currentVerbosity);

	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public void setForcedTimeout(Integer forcedTimeout) {
		this.forcedTimeout = forcedTimeout;
	}

}
