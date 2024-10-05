package com.sumit.coding.design_patterns.behavioral.chainOfResponsibility.problem.logging;

public class Logger {
    public void log(String message, String level) {
        switch (level.toUpperCase()) {
            case "DEBUG":
                System.out.println("DEBUG: " + message);
                break;
            case "INFO":
                System.out.println("INFO: " + message);
                break;
            case "ERROR":
                System.out.println("ERROR: " + message);
                break;
            default:
                System.out.println("UNSUPPORTED LOG LEVEL: " + level + ". Message: " + message);
                break;
        }
    }
}
