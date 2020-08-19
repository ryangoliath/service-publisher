package net.iqbusiness.messaging;

public interface MessageBrokerClient {
	
	public void send(String queue, String message);

}
