package com.rest.restassurred;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;

public class postman {
	
	public static Logger logger = LogManager.getLogger(postman.class);
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		logger.info("Hello");
		logger.error("Error");
		logger.warn("Warn");
		logger.fatal("Fatal");
		logger.debug("Debug");
		logger.trace("Trace");
		System.out.println("End");
	}

}
