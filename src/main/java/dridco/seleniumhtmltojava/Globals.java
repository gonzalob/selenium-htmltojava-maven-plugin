package dridco.seleniumhtmltojava;

public class Globals {

	/**
	 * Disable forcing timeouts by default
	 */
	private static final Integer DEFAULT_FORCED_TIMEOUT = -1;

	/**
	 * Default to full speed for test executions (no delay)
	 */
	private static final Integer DEFAULT_DELAY = 0;

	private static final Integer DEFAULT_TIMEOUT = 30000;

	private Globals() {
		// do not instantiate this class
	}

	public static Integer timeout = DEFAULT_TIMEOUT;

	public static Integer speed = DEFAULT_DELAY;

	public static Integer forcedTimeout = DEFAULT_FORCED_TIMEOUT;

}
