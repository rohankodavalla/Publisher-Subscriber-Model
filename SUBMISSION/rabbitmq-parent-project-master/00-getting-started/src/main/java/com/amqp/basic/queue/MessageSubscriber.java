package com.amqp.basic.queue;
/*
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageSubscriber {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
    Channel channel = connection.createChannel();

    DeliverCallback deliverCallback = (s, delivery) -> {
      System.out.println(new String(delivery.getBody(), "UTF-8"));
    };

    CancelCallback cancelCallback = s -> {
      System.out.println(s);
    };
    channel.basicConsume(CommonConfigs.DEFAULT_QUEUE, true, deliverCallback, cancelCallback);
  }
}
 
*/


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// Run me - fourth
public class MessageSubscriber {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ron");
        factory.setPassword("ron");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        String exchangeName = "EduCostStatExchange";
        //String queueName = "topic1";
        //String topic = "Cost-2013-Alabama-Private-4-year";
        //String queueName = "topic2";
        //String topic = "Top5-Expensive-2013-Private-4-year";
        //String queueName = "topic3";
        //String topic = "Top5-Economic-2013-Private-4-year";
        //String queueName = "topic4";
        //String topic = "Top5-HighestGrow-2021";
        String queueName = "topic5";
        String topic = "AverageExpense-2019-Public In-State-4-year";


        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declare the exchange
            channel.exchangeDeclare(exchangeName, "topic", true);

            // Declare the queue
            channel.queueDeclare(queueName, true, false, false, null);

            // Bind the queue to the exchange
            channel.queueBind(queueName, exchangeName, topic);

            // Create a consumer
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
    	        String message = new String(delivery.getBody(), "UTF-8");
    	        //System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey()+"':'"+message + "'");
    	        //System.out.println("Message received and processed successfully.");

    	    };
    	    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    	    System.out.println("Waiting for messages...");

            /*Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received message: " + message);
                }
            };

            // Start consuming messages
            channel.basicConsume(queueName, true, consumer);*/
        }
    }
}
