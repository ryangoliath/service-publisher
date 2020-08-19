package net.iqbusiness.main;

import java.io.Console;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import net.iqbusiness.console.InputStrategy;
import net.iqbusiness.console.InputStrategyFactory;

/**
 * main class<br>
 * Reads user input via console and publishes the input to a queue (RabbitMq).
 * */
public class Application {
	
	private static final Logger logger = Logger.getLogger(Application.class);
	
	public static void main(String[] args) throws IOException, TimeoutException {

		Console console;
		
		try {
			
			console = System.console();

			if (console == null) {
				logger.error("No console provided.");
			}
			
			while(true) {
				final String arg = console.readLine("[Type 'exit' to quit] Enter Name: ");
				
				InputStrategy strategy = InputStrategyFactory.getInputStrategy(arg);
				strategy.doOperation();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}