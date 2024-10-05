package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.solution.logging;

public interface Logger {
    void setNext(Logger nextLogger);
    void logMessage(String message, LogLevel level);
}