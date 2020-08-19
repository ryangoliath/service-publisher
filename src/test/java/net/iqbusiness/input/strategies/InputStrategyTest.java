package net.iqbusiness.input.strategies;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.iqbusiness.console.ExitOperation;
import net.iqbusiness.console.InputStrategy;
import net.iqbusiness.console.InputStrategyFactory;
import net.iqbusiness.console.InvalidOperation;
import net.iqbusiness.console.PublishOperation;

/**
 * Unit test to verify that the InputStrategyFactory produces the correct strategy for the expected user operation.
 * */
public class InputStrategyTest {
	
	@Test
	public void testInputStrategyTypes() {
		InputStrategy strategy;
		
		strategy = InputStrategyFactory.getInputStrategy("");
		assertEquals(InvalidOperation.class, strategy.getClass());
		
		strategy = InputStrategyFactory.getInputStrategy(null);
		assertEquals(InvalidOperation.class, strategy.getClass());
		
		strategy = InputStrategyFactory.getInputStrategy("exit");
		assertEquals(ExitOperation.class, strategy.getClass());
		
		strategy = InputStrategyFactory.getInputStrategy("Harry Potter");
		assertEquals(PublishOperation.class, strategy.getClass());
		
	}
	
}
