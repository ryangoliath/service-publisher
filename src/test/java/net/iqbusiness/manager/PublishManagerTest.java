package net.iqbusiness.manager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.iqbusiness.messaging.MessageBrokerClient;
import net.iqbusiness.messaging.manager.PublishManagerImpl;

/**
 * Test the PublishManager to verify that the message formatting is correct.
 * */
public class PublishManagerTest {

	@Mock
	MessageBrokerClient rabbitMqClient;
	
	PublishManagerImpl publishManagerImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		publishManagerImpl = new PublishManagerImpl(rabbitMqClient);
	}

	@Test
	public void tesstPublishOperation() {

		publishManagerImpl.publish("Harry Potter");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(rabbitMqClient).send(anyString(), captor.capture());
		
		assertEquals("Hello my name is, Harry Potter", captor.getValue());
		
	}

}
