package dridco.seleniumhtmltojava;

public final class Globals {

	public static final Integer NO_FORCED_TIMEOUT = -1;

	public static final Integer NO_DELAY_BETWEEN_INSTRUCTIONS = 0;

	public static final Integer DEFAULT_TIMEOUT = 30000;

	public static final Integer NO_TEST_TIMEOUT = 0;

	private static final Boolean DONT_BE_VERBOSE = false;

	private static Globals instance;

	public static void define(Integer timeout, Integer speed,
			Integer forcedTimeout, Integer testTimeout, Boolean verbose) {
		instance = new Globals(timeout, speed, forcedTimeout, testTimeout, verbose);
	}

	static {
		define(DEFAULT_TIMEOUT, //
				NO_DELAY_BETWEEN_INSTRUCTIONS, //
				NO_FORCED_TIMEOUT, //
				NO_TEST_TIMEOUT, //
				DONT_BE_VERBOSE);
	}

	private final Integer timeout;

	private final Integer speed;

	private final Integer forcedTimeout;

	private final Integer testTimeout;
	
	private final Boolean verbose;

	private Globals(Integer timeout, Integer speed, Integer forcedTimeout,
			Integer testTimeout, Boolean verbose) {
		this.timeout = timeout;
		this.speed = speed;
		this.forcedTimeout = forcedTimeout;
		this.testTimeout = testTimeout;
		this.verbose = verbose;
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
	
	public static Boolean verbose() {
		return instance.verbose;
	}

}
