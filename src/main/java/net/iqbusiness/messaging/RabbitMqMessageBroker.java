package net.iqbusiness.messaging;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import net.iqbusiness.properties.AppProperties;

/**
 * Singleton used for RabbitMq message broker connection and message publishing
 */
public class RabbitMqMessageBroker {
	
	private static final Logger logger = Logger.getLogger(RabbitMqMessageBroker.class);

	private static final RabbitMqMessageBroker instance = new RabbitMqMessageBroker();
	
	private ConnectionFactory factory;

	private RabbitMqMessageBroker() {
		this.factory = new ConnectionFactory();
		this.factory.setUsername(AppProperties.getProperty("app.rabbit.username:guest"));
		this.factory.setPassword(AppProperties.getProperty("app.rabbit.password:guest"));
		this.factory.setHost(AppProperties.getProperty("app.rabbit.host:localhost"));
		this.factory.setPort(Integer.parseInt(AppProperties.getProperty("app.rabbit.port:5672")));
		
		logger.info(String.format("Message Engine Configured for %s:%s", AppProperties.getProperty("app.rabbit.host:localhost"), AppProperties.getProperty("app.rabbit.port:5672")));
	}

	public void send(String queue, String message) throws IOException, TimeoutException {
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(queue, false, false, false, null);
			channel.basicPublish("", queue, null, message.getBytes());
			logger.info(String.format("[%s] Message sent '%s'", queue, message));
		}
	}
	
	public static RabbitMqMessageBroker getInstance() {
		return instance;
	}

}
