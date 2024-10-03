package com.sumit.coding.design_patterns.behavioral.strategy.problem;

public class SportsVehicle extends Vehicle {

    @Override
    public void drive() {
        // some other logic -- code duplication
        System.out.println("sports drive capability");
    }
}
