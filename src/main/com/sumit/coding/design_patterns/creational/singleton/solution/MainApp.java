package com.sumit.coding.design_patterns.creational.singleton.solution;

/**
 * Public class that uses singleton class
 */
public class MainApp {
    public static void main(String[] args) {
        // Both config1 and config2 refer to the same instance
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println(config1.equals(config2)); // true

        System.out.println(config1.getConfiguration());
        System.out.println(config2.getConfiguration());
    }
}
