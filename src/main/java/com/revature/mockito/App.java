package com.revature.mockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        System.out.println("This is trials !");

        logger.info("Example log from {}", App.class.getSimpleName());
        // adding a trace log to our log file
        logger.trace("Example TRACE log from {}", App.class.getSimpleName());

        // adding a debug log to our log file
        logger.debug("Example DEBUG log from {}", App.class.getSimpleName());

        // adding a info log to our log file
        logger.info("Example INFO log from {}", App.class.getSimpleName());

        // adding a warn log to our log file
        logger.warn("Example WARN log from {}", App.class.getSimpleName());

        // adding a error log to our log file
        logger.error("Example ERROR log from {}", App.class.getSimpleName());
    }
}