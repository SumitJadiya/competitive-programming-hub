package com.sumit.coding.design_patterns.creational.singleton.problem;

public class MainApp {
    public static void main(String[] args) {
        ConfigurationManager config1 = new ConfigurationManager();
        ConfigurationManager config2 = new ConfigurationManager();
        ConfigurationManager config3 = new ConfigurationManager();
        ConfigurationManager config4 = new ConfigurationManager();

        System.out.println(config1.equals(config2)); // false
        System.out.println(config2.equals(config3)); // false
        System.out.println(config3.equals(config4)); // false

        System.out.println(config1.getConfiguration());
        System.out.println(config2.getConfiguration());
        System.out.println(config3.getConfiguration());
        System.out.println(config4.getConfiguration());
    }
}

/*
 * In the non-singleton approach, if we create multiple instances of ConfigurationManager, each instance will load its own copy of the configuration,
 * which wastes memory and can lead to inconsistent configuration being used across the application.
 *
 * Problems:
 *
 *	•	Each call to new ConfigurationManager() creates a new instance.
 *	•	Memory Waste: Each instance occupies memory unnecessarily.
 *	•	Inconsistent State: If one instance changes the configuration, the other instances won’t reflect that change.
 * */