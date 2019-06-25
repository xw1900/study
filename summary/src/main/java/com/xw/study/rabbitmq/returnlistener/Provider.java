package com.xw.study.rabbitmq.returnlistener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Provider {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.100");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("root");
		connectionFactory.setPassword("vincent");
		connectionFactory.setVirtualHost("my_vhost");
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.addReturnListener(new ReturnListener() {
			
			@Override
			public void handleReturn(int replyCode, String replyText,
		            String exchange, String routingKey,
		            AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.err.println("---------handle  return----------");
				System.err.println("replyCode: " + replyCode);
				System.err.println("replyText: " + replyText);
				System.err.println("exchange: " + exchange);
				System.err.println("routingKey: " + routingKey);
				System.err.println("properties: " + properties);
				System.err.println("body: " + new String(body));
			}
		});
		
		String exchangeName = "amq.topic";
		String routingkey = "routingkey005.gg";
		String message = "routingkey003.ggg";
		// Mandatory true:監聽
		channel.basicPublish(exchangeName, routingkey, true, null, message.getBytes());
		
//		channel.close();
//		connection.close();
	}
}
