package com.amzn.demo;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingDemo {

	// Create a logger with a label (in this case it is the FQ Class name)
	// static Logger logger = Logger.getLogger(LoggingDemo.class.getName());

	// Create a logger with a label "Test Logger"
	static Logger logger = Logger.getLogger("Test Logger");

	public static void main(String[] args) throws SecurityException, IOException {
		System.out.println("Current log level: " + logger.getLevel());
		logger.setLevel(Level.CONFIG);

		// Redirect all logs to a file
		FileHandler fileLogger = new FileHandler("mylogs.log");
		logger.addHandler(fileLogger);

		for (int i = 0; i < 10; i++) {
			logger.info("Inside for loop i=" + i); // use this for informational message
			// logger.warning("Inside for loop i="+i);// use this for warning messages
			// logger.severe("Inside for loop i="+i);// use when some error conditionals
			logger.finest("Inside for loop i=" + i);
			logger.config("Inside for loop i=" + i);
		}
		;

		// we can create any number of loggers in a project/class.
		// each can be configured to a different log file
		// logger with some other label
		Logger logger1 = Logger.getLogger("Test Logger 2");
		FileHandler fileLogger2 = new FileHandler("mylogs2.log");
		fileLogger2.setFormatter(new SimpleFormatter());
		logger1.addHandler(fileLogger2);
		logger1.setLevel(Level.ALL);
		logger1.info("Test message 1");
		logger1.info("Test message 2");
	}

}
