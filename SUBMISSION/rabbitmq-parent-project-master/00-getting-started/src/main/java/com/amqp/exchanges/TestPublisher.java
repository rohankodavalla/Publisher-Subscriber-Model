/*package com.amqp.basic.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessagePublisher {
  public static void main(String[] args) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
    Channel channel = connection.createChannel();

    channel.queueDeclare(CommonConfigs.DEFAULT_QUEUE, true, false, false, null);
    for (int i = 0; i < 4; i++) {
      String message = "Getting started with rabbitMQ - Msg" + i;
      //publish - (exchange, routingKey, properties, message)
      channel.basicPublish("", CommonConfigs.DEFAULT_QUEUE, null, message.getBytes());
    }
    channel.close();
    connection.close();
  }
}
 */

/*  <<<<<  WORKING WITH RABBIT MQ >> 
 * 
 package com.amqp.basic.queue;

import com.amqp.basic.queue.CommonConfigs;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// Run me - third
public class MessagePublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ron");
        factory.setPassword("ron");
        factory.setPort(5672);
        factory.setVirtualHost("/");


        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declare the exchanges
            channel.exchangeDeclare("EduCostStatQueryOne", "topic");
            channel.exchangeDeclare("EduCostStatQueryTwo", "topic");
            channel.exchangeDeclare("EduCostStatQueryThree", "topic");
            channel.exchangeDeclare("EduCostStatQueryFour", "topic");
            channel.exchangeDeclare("EduCostStatQueryFive", "topic");

            
            String year = "2022";
            String state = "CA";
            String type = "private";
            String length = "4";
            String message = "Message for EduCostStatQueryOne";

            // Publish the message to the exchange for EduCostStatQueryOne
            channel.basicPublish("EduCostStatQueryOne", "Cost-" + year + "-" + state + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryTwo
            message = "Message for EduCostStatQueryTwo";
            channel.basicPublish("EduCostStatQueryTwo", "Top5-Expensive-" + year + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryThree
            message = "Message for EduCostStatQueryThree";
            channel.basicPublish("EduCostStatQueryThree", "Top5-Economic-" + year + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryFour
            message = "Message for EduCostStatQueryFour";
            channel.basicPublish("EduCostStatQueryFour", "Top5-HighestGrow-2020-2022-5-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryFive
            message = "Message for EduCostStatQueryFive";
            channel.basicPublish("EduCostStatQueryFive", "AverageExpense-" + year + "-" + type + "-" + length, null, message.getBytes());
        }
    }
}
*/

// try mongodb thing 


 package com.amqp.exchanges;

 import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
 import com.mongodb.client.MongoClients;
 import com.mongodb.client.MongoCollection;
 import com.mongodb.client.MongoDatabase;
 import com.mongodb.client.model.Filters;
 import com.mongodb.client.model.Sorts;

 import org.bson.Document;

 import com.rabbitmq.client.Channel;
 import com.rabbitmq.client.Connection;
 import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;

import java.io.IOException;
 import java.util.concurrent.TimeoutException;

// Run me - third
public class TestPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ron");
        factory.setPassword("ron");
        factory.setPort(5672);
        //factory.setVirtualHost("/");


        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declare the exchanges
            channel.exchangeDeclare("EduCostStatExchange", "topic", true);
            //channel.exchangeDeclare("EduCostStatExchange", "topic", true);
            //channel.exchangeDeclare("EduCostStatQueryThree", "topic3");
            //channel.exchangeDeclare("EduCostStatQueryFour", "topic4");
            //channel.exchangeDeclare("EduCostStatQueryFive", "topic5"); 

            Consumer consumer = new DefaultConsumer(channel) {
            	//...
            };
                
            
            
            // MongoDB database and collection setup
            MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("EduCostStatQueryFive");
            FindIterable<Document> results = collection.find();

            
            // Query for EduCostStatQueryOne
           /*
            int year = 2013;
            String state = "Alabama";
            String type = "Private";
            String length = "4-year";
            String expense = "Fees/Tuition";
            String message = "Message for EduCostStatQueryOne";
            
         // Query for EduCostStatQueryTwo
            /*
            int year = 2013;
            String type = "Private";
            String length = "4-year";
            String message = "Message for EduCostStatQueryTwo";

         // Query for EduCostStatQueryThree
            
            int year = 2013;
            String type = "Private";
            String length = "4-year";
            String message = "Message for EduCostStatQueryThree";

        // Query for EduCostStatQueryFour
            int latestYear = 2021;
            String type = "Public";
            String length = "4-year";
            int[] pastYears = new int[]{2020, 2019, 2018, 2017};
            String message = "Message for EduCostStatQueryFour";
   */
        // Query for EduCostStatQueryFive
            
            int year = 2019;
            String type = "Public In-State";
            String length = "4-year";
            String message = "Message for EduCostStatQueryFive";
            
         // Display query results
            for (Document result : results) {
                System.out.println(result.toJson());
            }
            // Publish the message to the exchange for EduCostStatQueryOne
            //channel.basicPublish("EduCostStatExchange", "Cost-" + year + "-" + state + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryTwo
            //message = "Message for EduCostStatQueryTwo";
            //channel.basicPublish("EduCostStatExchange", "Top5-Expensive-" + year + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryThree
           // message = "Message for EduCostStatQueryThree";
           // channel.basicPublish("EduCostStatExchange", "Top5-Economic-" + year + "-" + type + "-" + length, null, message.getBytes());
            
            // Publish the message to the exchange for EduCostStatQueryFour
          // message = "Message for EduCostStatQueryFour";
           //channel.basicPublish("EduCostStatExchange", "Top5-HighestGrow-2020-2022-5-" + type + "-" + length, null, message.getBytes());
           //channel.basicPublish("EduCostStatExchange", "Top5-HighestGrow-2021" + latestYear+ "-" + type + "-" + length + "-" + pastYears, null, message.getBytes());
            // Publish the message to the exchange for EduCostStatQueryFive
           message = "Message for EduCostStatQueryFive";
           channel.basicPublish("EduCostStatExchange", "AverageExpense-" + year + "-" + type + "-" + length, null, message.getBytes());
          
        }
    }
}
    
