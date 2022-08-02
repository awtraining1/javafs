package com.mycompany.app;

import javax.jms.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class App2_Queue_MessageConsumer_Demo {

	public static void main(String[] args) throws Exception {
		// Step 1 Obtain the ActiveMQ connection
		// Step 2 Creation a session
		// Step 3 Get associated with a particular Queue
		// Step 4 Consume a message(s) and put the on the queue.
		// Step 5 close the connection

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		// or use new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("ORDER_QUEUE");

		MessageConsumer messageConsumer = session.createConsumer(destination);

		// Listen for ever
		int messageLimit=1000;
		while (messageLimit-- > 0) {
			Message message = messageConsumer.receive();

			if (message instanceof TextMessage) {
				TextMessage txtMsg = (TextMessage) message;
				System.out.println("Got this Message from the Queue : " + txtMsg.getText());
			}
			;
		}
		;

		messageConsumer.close();
		session.close();
		connection.close();

		// 32A enhance this producer so that it produces 5 different text message orders
	}

}
