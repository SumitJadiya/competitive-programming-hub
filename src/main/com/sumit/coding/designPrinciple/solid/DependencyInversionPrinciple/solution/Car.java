package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution;

import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.Engine;

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