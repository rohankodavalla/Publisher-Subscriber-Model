package com.amqp.exchanges;

import com.amqp.basic.queue.CommonConfigs;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//Run me - Third
public class CreateBindings {
	  public static void main(String[] args) throws IOException, TimeoutException {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    factory.setUsername("ron");
	    factory.setPassword("ron");
	    factory.setPort(5672);
	    factory.setVirtualHost("/");

	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    // Bind queues to the exchange
	  //Create bindings - (queue, exchange, routingKey)
	    channel.queueBind("topic1", "EduCostStatExchange", "Cost-[Year]-[State]-[Type]-[Length]");
	    channel.queueBind("topic2", "EduCostStatExchange", "Top5-Expensive-[Year]-[Type]-[Length]");
	    channel.queueBind("topic3", "EduCostStatExchange", "Top5-Economic-[Year]-[Type]-[Length]");
	    channel.queueBind("topic4", "EduCostStatExchange", "Top5-HighestGrow-[Years]");
	    channel.queueBind("topic5", "EduCostStatExchange", "AverageExpense-[Year]-[Type]-[Length]");

	    channel.close();
	    connection.close();
	  }
	}
