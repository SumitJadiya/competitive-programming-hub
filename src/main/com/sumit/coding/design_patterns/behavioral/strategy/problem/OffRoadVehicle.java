package com.sumit.coding.design_patterns.behavioral.strategy.problem;

public class OffRoadVehicle extends Vehicle {

    @Override
    public void drive() {
        // some other logic -- code duplication
        System.out.println("off road drive capability");
    }
}
