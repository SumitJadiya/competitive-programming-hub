package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.problem;

import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.problem.logging.Logger;

public class LoggerClient {
    public static void main(String[] args) {
        Logger logger = new Logger();

        // Test logging at different levels
        logger.log("This is a debug message.", "DEBUG"); // Handled by Logger
        logger.log("This is an info message.", "INFO");  // Handled by Logger
        logger.log("This is an error message.", "ERROR"); // Handled by Logger
        logger.log("This is a warning message.", "WARNING"); // Handled as unsupported
    }
}

/*
* Problems with This Approach

	1.	Tight Coupling: The Logger class is responsible for handling all log levels within a single method. This means any changes to log levels or their handling will require modifications in the same class.
	2.	Single Responsibility Principle (SRP) Violation: The Logger class does too much; it decides how to log messages based on the log level and performs the logging itself.
	3.	Difficult to Extend: If a new log level needs to be added, the Logger class must be modified, which is not ideal for maintainability.
	4.	Testing Challenges: Testing the logging functionality could become cumbersome since all logic is contained within a single class, making it harder to isolate and test specific behaviors.
	5.	Reduced Flexibility: The implementation does not allow for dynamic logging behavior (e.g., different handlers for different levels), as everything is hardcoded within the log method.
* */