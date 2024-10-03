package com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Sports Drive Capability");
    }
}
