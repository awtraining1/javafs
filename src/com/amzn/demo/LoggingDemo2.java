package com.amzn.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo2 {

	static {
		String path = LoggingDemo2.class.getClassLoader()
				.getResource("logging.properties").getFile();

		// Read the logging setting from the logging.properties file
		System.setProperty("java.util.logging.config.file", path);
	};
	
	static Logger logger = Logger.getLogger("Test Logger");

	public static void main(String[] args) {
		logger.setLevel(Level.ALL);
		logger.info("Hello Hello");	// logged in mygoodlogger%u.log file as per the props file.
		
		logger.finest("Hello Finest 2");
		logger.fine("Hello Fine 2");
		
	}

}
