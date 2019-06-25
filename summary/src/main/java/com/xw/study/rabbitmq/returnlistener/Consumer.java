package com.xw.study.rabbitmq.returnlistener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.100");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("root");
		connectionFactory.setPassword("vincent");
		connectionFactory.setVirtualHost("my_vhost");
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		String queueName = "queue003";
		channel.basicConsume(queueName, true, new MyConsumer(channel));
	}
}
