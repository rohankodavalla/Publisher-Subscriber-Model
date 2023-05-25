/*package com.amqp.exchanges;

import com.amqp.basic.queue.CommonConfigs;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//Run me - second
public class CreateQueues {
  public static void main(String[] args) throws IOException, TimeoutException {

    ConnectionFactory factory = new ConnectionFactory();
    Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
    Channel channel = connection.createChannel();

    //Create the Queues
    channel.queueDeclare("MobileQ", true, false, false, null);
    channel.queueDeclare("ACQ", true, false, false, null);
    channel.queueDeclare("LightQ", true, false, false, null);

    channel.close();
    connection.close();
  }
}
 */

package com.amqp.exchanges;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CreateQueues {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ron");
        factory.setPassword("ron");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Create the Queues
        channel.queueDeclare("topic1", true, false, false, null);
        channel.queueDeclare("topic2", true, false, false, null);
        channel.queueDeclare("topic3", true, false, false, null);
        channel.queueDeclare("topic4", true, false, false, null);
        channel.queueDeclare("topic5", true, false, false, null);

        channel.close();
        connection.close();
    }
}
