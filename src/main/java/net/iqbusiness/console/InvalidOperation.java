package net.iqbusiness.console;

import org.apache.log4j.Logger;

public class InvalidOperation implements InputStrategy {
	
	private static final Logger logger = Logger.getLogger(InvalidOperation.class);

	/**
	 * Do nothing... simply provide an error message
	 * */
	public void doOperation() {
		logger.error("No valid name provided.");
	}

}