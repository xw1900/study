package com.xw.study.rabbitmq.limit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
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
		
		String exchangeName = "amq.topic";
		String routingkey = "routingkey003.gg";
		String message = "routingkey003.ggg";
		// Mandatory true:監聽
//		MessageProperties.PERSISTENT_TEXT_PLAIN:消息持久化
		channel.basicPublish(exchangeName, routingkey, false, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		
		channel.close();
		connection.close();
	}
}
