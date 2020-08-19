package net.iqbusiness.console;

import net.iqbusiness.messaging.manager.PublishManager;
import net.iqbusiness.messaging.manager.PublishManagerImpl;

public class PublishOperation implements InputStrategy {
	
	private PublishManager publisher;
	private String message;
	
	public PublishOperation(String message) {
		this.message = message;
		publisher = new PublishManagerImpl();
	}
	
	public PublishOperation(String message, PublishManagerImpl publisher) {
		this.message = message;
		this.publisher = publisher;
	}

	public void doOperation() {
		publisher.publish(message);
	}

}
