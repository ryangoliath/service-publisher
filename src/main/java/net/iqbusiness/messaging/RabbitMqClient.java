package net.iqbusiness.messaging;

import org.apache.log4j.Logger;

/**
 * RabbitMq Message Broker client
 * */
public class RabbitMqClient implements MessageBrokerClient {
	
	private static final Logger logger = Logger.getLogger(RabbitMqClient.class);
	
	@Override
	public void send(String queue, String message) {
		try {
			RabbitMqMessageBroker.getInstance().send(queue, message);
		} catch (Exception e) {
			logger.error(String.format("Error sending message '%s' over queue: '%s'", message, queue));
		}
	}
	
}