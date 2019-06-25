package com.xw.study.rabbitmq.exchangetype;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

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
		
		channel.close();
		connection.close();
	}

	private static void fanout(Channel channel) throws Exception {
		String exchange = "amq.fanout";
		String routingkey = "";
		String message = "fanoutfanoutfanout";
		channel.basicPublish(exchange, routingkey, null, message.getBytes());
	}

	private static void topic(Channel channel) throws Exception {
		String exchange = "amq.topic";
		String routingkey = "routingkey003.yy.uu.ll";
		String message = "topictopictopicyyuu66";
		channel.basicPublish(exchange, routingkey, null, message.getBytes());
	}

	private static void direct(Channel channel) throws Exception {
		String exchange = "amq.direct";
		String routingkey = "routingkey002";
		String message = "hhhhhhhhhh";
		channel.basicPublish(exchange, routingkey, null, message.getBytes());
	}
}
