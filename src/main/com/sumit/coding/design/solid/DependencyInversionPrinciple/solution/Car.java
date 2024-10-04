package com.sumit.coding.design.solid.DependencyInversionPrinciple.solution;

public class Car {
    private Engine engine;

    // Constructor Dependency Injection
    public Car(Engine engine) {
        this.engine = engine; // Injecting the engine dependency
    }

    public void startCar() {
        engine.start();
    }
}