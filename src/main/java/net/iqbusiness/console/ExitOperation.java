package net.iqbusiness.console;

import org.apache.log4j.Logger;

public class ExitOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(ExitOperation.class);

	/**
	 * Output the exit to the user.<br>
	 * Terminate JVM
	 * */
	public void doOperation() {
		logger.info("Exiting...");
		System.exit(0);
	}

}
