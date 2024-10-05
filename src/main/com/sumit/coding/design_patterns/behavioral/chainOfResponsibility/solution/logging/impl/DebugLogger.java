package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.impl;

import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.LogLevel;
import com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging.Logger;

public class DebugLogger implements Logger {
    private Logger nextLogger;

    @Override
    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(String message, LogLevel level) {
        if (level == LogLevel.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else if (nextLogger != null) {
            nextLogger.logMessage(message, level);
        }
    }
}
