package com.amqp.basic.queue;
/*
public class CommonConfigs {
  public static final String DEFAULT_QUEUE = "Queue-1";
  public static final String AMQP_URL = "amqp://ron:ron@localhost:5672/";
}*/
import com.rabbitmq.client.ConnectionFactory;

public class CommonConfigs {
    private final static String HOST_NAME = "localhost";
    private final static String QUEUE_NAME = "topic5";
    private final static String EXCHANGE_NAME = "EduCostStatQueryFive";
    private final static String ROUTING_KEY = "AverageExpense-2019-Public In-State-4-year";
    public static final String AMQP_URL = "amqp://ron:ron@localhost:5672/";

    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        factory.setUsername("ron");
        factory.setPassword("ron");
        factory.setPort(5672);
        return factory;
    }

    public static String getQueueName() {
        return QUEUE_NAME;
    }

    public static String getExchangeName() {
        return EXCHANGE_NAME;
    }

    public static String getRoutingKey() {
        return ROUTING_KEY;
    }
}
