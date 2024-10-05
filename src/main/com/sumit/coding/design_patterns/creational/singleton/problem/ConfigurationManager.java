package com.sumit.coding.design_patterns.creational.singleton.problem;

public class ConfigurationManager {

    private final String configuration;

    public ConfigurationManager() {
        // Load configuration from a file or database
        this.configuration = "DatabaseConfig";
    }

    public String getConfiguration() {
        return configuration;
    }
}
