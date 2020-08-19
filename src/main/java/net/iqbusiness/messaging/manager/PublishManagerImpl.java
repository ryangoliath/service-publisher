package net.iqbusiness.messaging.manager;

import net.iqbusiness.messaging.MessageBrokerClient;
import net.iqbusiness.messaging.RabbitMqClient;

public class PublishManagerImpl implements PublishManager {
	
	public static final String QUEUE_NAME = "IQ_BUSINESS.ASSESSMENT.RYAN.GOLIATH";
	private static final String MESSAGE_FORMAT = "Hello my name is, %s";
	
	private MessageBrokerClient messageBrokerClient;
	
	public PublishManagerImpl() {
		// Default to RabbitMq
		messageBrokerClient = new RabbitMqClient();
	}
	
	public PublishManagerImpl(MessageBrokerClient messageBrokerClient) {
		this.messageBrokerClient = messageBrokerClient;
	}
	
	/**
	 * Publishes a message to the IQ_BUSINESS.ASSESSMENT.RYAN.GOLIATH queue
	 * 
	 * @param message - The message to publish
	 * */
	public void publish(String message) {
		String formattedMessage = String.format(MESSAGE_FORMAT, message);
		messageBrokerClient.send(QUEUE_NAME, formattedMessage);
	}

}
