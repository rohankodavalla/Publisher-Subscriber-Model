# Publisher-Subscriber-Model


**What is the Project About**

This project is designed to practice pub/sub (publish/subscribe) message-oriented programming. It builds upon data collections created (in a previous project), using a public dataset from Kaggle that contains the average cost of undergraduate college by state. The project involves querying and processing various educational cost statistics, publishing these statistics to specific topics, and subscribing to these topics to consume the data.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Tools and Technologies Used**

- Programming Languages: Java
- Frameworks and Libraries: RabbitMQ, pika (Python library for RabbitMQ)
- Database: MongoDB (cloud service)
- Messaging Service: RabbitMQ
- Configuration Management: Configuration file for topic customization

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Solution Explanation**

- Data Retrieval:

The producer retrieves datasets from MongoDB cloud service based on predefined collections and parameters specified in a configuration file.

- Publishing Data:

The producer publishes the data to RabbitMQ exchange topics using routing keys that match the topic for each queue.

- Consuming Data:

The consumer subscribes to specific topics and receives data from the corresponding queue.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Task Details**

- RabbitMQ Installation:

Install RabbitMQ server either on a local computer or on Oracle Cloud.

- Producer and Consumer Programming:

Implement the producer and consumer using RabbitMQ exchange topic libraries. Ensure the producer and consumer run on the same node but without using multi-threading within the same application.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Result**

The project successfully demonstrates the implementation of a pub/sub message-oriented architecture using RabbitMQ. 

- Key outcomes include:

1. Retrieval of datasets from MongoDB based on specified queries.
2. Publishing of data to specific topics in RabbitMQ.
3. Consumption of data from subscribed topics by the consumer.
4. Screenshots and Documentation
5. The final report includes screenshots documenting the solutions to Task 2.
6. The project code is organized with a pom.xml file for dependency management.


<img width="786" alt="Screenshot 2024-07-29 at 7 19 48 PM" src="https://github.com/user-attachments/assets/9bdcd681-3001-45cf-b029-7b495ccce9a5">



COEN 6731 Winter 2023 Assignment Three
Assignment -3 DSS

was graded 100/100 
