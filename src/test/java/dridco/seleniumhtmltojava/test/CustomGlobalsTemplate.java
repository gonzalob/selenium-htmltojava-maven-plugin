package dridco.seleniumhtmltojava.test;

import dridco.seleniumhtmltojava.Globals;

class CustomGlobalsTemplate {

	private Integer timeout;
	private Integer speed;
	private Integer forcedTimeout;

	public CustomGlobalsTemplate() {
		timeout = Globals.timeout();
		speed = Globals.speed();
		forcedTimeout = Globals.forcedTimeout();
	}

	public void execute(CustomGlobalsCallback callback) {
		Integer currentTimeout = Globals.timeout();
		Integer currentSpeed = Globals.speed();
		Integer currentForcedTimeout = Globals.forcedTimeout();
		Globals.define(timeout, speed, forcedTimeout);
		callback.execute();
		Globals.define(currentTimeout, currentSpeed, currentForcedTimeout);

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
