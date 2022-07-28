package com.mycompany.app;

import javax.jms.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class App1_Queue_MessageProducer_Demo {

	public static void main(String[] args) throws Exception {
		//Step 1 Obtain the ActiveMQ connection
		//Step 2 Creation a session
		//Step 3 Get associated with a particular Topic
		//Step 4  Produce a message(s) and put the on the Topic.
		//Step 5 close the connection
		
		ConnectionFactory connectionFactory = 
				new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL); 
		// or use new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		Connection connection =  connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);		

		Destination destination = session.createQueue("ORDER_QUEUE");
		
		MessageProducer messageProducer = session.createProducer(destination);
		
		
		TextMessage textMsg = session.createTextMessage("Movie #1234 was good");
		textMsg.setJMSExpiration(3000);
		
		messageProducer.send(textMsg);
		System.out.println("Sending Message : " + textMsg);		
		
		
		messageProducer.close();
		session.close();
		connection.close();

		// 32B enhance this producer so that it produces 5 different text message orders
	}

}
