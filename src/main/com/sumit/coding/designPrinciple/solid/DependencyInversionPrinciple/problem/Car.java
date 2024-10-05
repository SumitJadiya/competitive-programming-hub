package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.problem;

/*
 * Here’s an example where the Car class is tightly coupled with the PetrolEngine. The car cannot use any other engine without modifying the Car class.
 *
 * The Dependency Injection Principle is a part of the Dependency Inversion Principle (DIP), one of the SOLID principles.
 * It suggests that high-level modules should not depend on low-level modules; both should depend on abstractions (interfaces).
 * Furthermore, abstractions should not depend on details, but details should depend on abstractions.
 * In other words, this principle promotes loosely coupled code by injecting dependencies rather than creating them inside a class.
 *
 * 	•	Tight Coupling: The Car class is dependent on PetrolEngine. If you want to switch to a DieselEngine or ElectricEngine, you would need to modify the Car class.
 *	•	Difficult to Extend: Every time a new engine type is added, you need to change the Car class, violating the Open/Closed Principle as well.
 * */
public class Car {
    private PetrolEngine engine;

    public Car() {
        this.engine = new PetrolEngine(); // Tight coupling
    }

    public void startCar() {
        engine.start();
    }
}