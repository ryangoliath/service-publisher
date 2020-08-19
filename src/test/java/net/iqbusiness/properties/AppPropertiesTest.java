package net.iqbusiness.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.iqbusiness.properties.AppProperties;

/**
 * Unit test to verify that the app properties are loaded correctly.
 * */
public class AppPropertiesTest {
	
	@Test
	public void testPropertyLoading() {
		assertNotNull(AppProperties.getProperty("app.rabbit.host"));
		assertEquals("localhost", AppProperties.getProperty("app.rabbit.host"));
	}
	
}
