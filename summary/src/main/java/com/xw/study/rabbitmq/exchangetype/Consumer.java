package com.xw.study.rabbitmq.exchangetype;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setVirtualHost("my_vhost");
		connectionFactory.setHost("192.168.31.100");
		connectionFactory.setUsername("root");
		connectionFactory.setPassword("vincent");
		connectionFactory.setPort(5672);
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
//		direct(channel);
//		topic(channel);
		fanout(channel);
	}

	private static void fanout(Channel channel) throws Exception {
		String queueName = "queue004";
		String exchangeName = "amq.fanout";
		String exchangeType = "fanout";
		String routingkey = "";
		channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);
		channel.queueDeclare(queueName, false, false, false, null);
		channel.queueBind(queueName, exchangeName, routingkey);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);
		
		while(true) {
			Delivery delivery = consumer.nextDelivery();
			System.out.println(new String(delivery.getBody()));
		}
	}

	private static void topic(Channel channel) throws Exception {
		String queueName = "queue003";
		String exchangeName = "amq.topic";
		String exchangeType = "topic";
		String routingkey = "routingkey003.#";
		channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingkey);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);
		
		while(true) {
			Delivery delivery = consumer.nextDelivery();
			System.out.println(new String(delivery.getBody()));
		}
	}

	private static void direct(Channel channel) throws Exception {
		String queueName = "queue002";
//		String exchangeName = "amq.direct";
//		String exchangeType = "direct";
//		String routingkey = "routingkey002";
//		channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);
//		channel.queueDeclare(queueName, true, false, false, null);
//		channel.queueBind(queueName, exchangeName, routingkey);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);
		
		while(true) {
			Delivery delivery = consumer.nextDelivery();
			System.out.println(new String(delivery.getBody()));
		}
	}
}
