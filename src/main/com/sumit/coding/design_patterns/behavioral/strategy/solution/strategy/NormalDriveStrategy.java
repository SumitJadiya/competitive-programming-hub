package com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
}
