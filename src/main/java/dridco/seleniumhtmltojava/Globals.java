package dridco.seleniumhtmltojava;

public class Globals {

	/**
	 * Disable forcing timeouts by default
	 */
	public static final Integer DEFAULT_FORCED_TIMEOUT = -1;

	/**
	 * Default to full speed for test executions (no delay)
	 */
	public static final Integer DEFAULT_DELAY = 0;

	public static final Integer DEFAULT_TIMEOUT = 30000;

	private static Globals instance;

	public static void define(Integer timeout, Integer speed,
			Integer forcedTimeout) {
		instance = new Globals(timeout, speed, forcedTimeout);
	}

	static {
		define(DEFAULT_TIMEOUT, DEFAULT_DELAY, DEFAULT_FORCED_TIMEOUT);
	}

	private final Integer timeout;

	private final Integer speed;

	private final Integer forcedTimeout;

	private Globals(Integer timeout, Integer speed, Integer forcedTimeout) {
		this.timeout = timeout;
		this.speed = speed;
		this.forcedTimeout = forcedTimeout;
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

}
