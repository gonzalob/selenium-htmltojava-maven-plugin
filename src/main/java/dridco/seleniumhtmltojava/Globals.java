package dridco.seleniumhtmltojava;

public final class Globals {

	public static final Integer NO_FORCED_TIMEOUT = -1;

	public static final Integer NO_DELAY_BETWEEN_INSTRUCTIONS = 0;

	public static final Integer DEFAULT_TIMEOUT = 30000;

	public static final Integer NO_TEST_TIMEOUT = 0;

	private static Globals instance;

	public static void define(Integer timeout, Integer speed,
			Integer forcedTimeout, Integer testTimeout) {
		instance = new Globals(timeout, speed, forcedTimeout, testTimeout);
	}

	static {
		define(DEFAULT_TIMEOUT, //
				NO_DELAY_BETWEEN_INSTRUCTIONS, //
				NO_FORCED_TIMEOUT, //
				NO_TEST_TIMEOUT);
	}

	private final Integer timeout;

	private final Integer speed;

	private final Integer forcedTimeout;

	private final Integer testTimeout;

	private Globals(Integer timeout, Integer speed, Integer forcedTimeout,
			Integer testTimeout) {
		this.timeout = timeout;
		this.speed = speed;
		this.forcedTimeout = forcedTimeout;
		this.testTimeout = testTimeout;
	}

	public static Integer timeout() {
		return instance.timeout;
	}

	public static Integer speed() {
		return instance.speed;
	}

	public static Integer forcedTimeout() {
		return instance.forcedTimeout;
	}

	public static Integer testTimeout() {
		return instance.testTimeout;
	}

}
