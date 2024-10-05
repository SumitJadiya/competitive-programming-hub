package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution;

import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.LogLevel;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.Logger;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.chain.LoggerChain;

public class LoggerClient {
    private Logger logger;

    public LoggerClient(Logger logger) {
        this.logger = logger;
    }

    public void log(String message, LogLevel level) {
        logger.logMessage(message, level);
    }

    public static void main(String[] args) {
        LoggerChain loggerChain = new LoggerChain();
        LoggerClient loggerClient = new LoggerClient(loggerChain.getLoggerChain());

        // Test logging at different levels
        loggerClient.log("This is a debug message.", LogLevel.DEBUG); // Handled by DebugLogger
        loggerClient.log("This is an info message.", LogLevel.INFO);  // Handled by InfoLogger
        loggerClient.log("This is an error message.", LogLevel.ERROR); // Handled by ErrorLogger
        loggerClient.log("This is a warning message.", null); // Not handled, no logger for unrecognized level
    }
}
