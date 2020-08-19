package net.iqbusiness.console;

import org.apache.commons.lang3.StringUtils;

public class InputStrategyFactory {
	
	private static final String CONST_EXIT = "exit";
	
	public static InputStrategy getInputStrategy(String arg) {
		
		InputStrategy strategy;
		
		if(StringUtils.isBlank(arg)) {
			strategy = new InvalidOperation();
		} else if(CONST_EXIT.equalsIgnoreCase(arg)) {
			strategy = new ExitOperation();
		} else {
			strategy = new PublishOperation(arg);
		}
		
		return strategy;
	}
	
}