package com.sumit.coding.design_patterns.creational.singleton.solution;

/**
 * Class that implements Singleton design Pattern
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String configuration;

    // Private constructor prevents instantiation from outside the class
    private ConfigurationManager() {
        // Load configuration from a file or database
        this.configuration = "DatabaseConfig";
    }

    /**
     * @return object using lazy initialization
     */
    static ConfigurationManager getInstance() {

        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getConfiguration() {
        return configuration;
    }
}
