package com.sumit.coding.design_patterns.behavioral.strategy.solution;

import com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveObject;

    // constructor injection
    Vehicle(DriveStrategy driveObj) {
        this.driveObject = driveObj;
    }

    public void drive() {
        driveObject.drive();
    }
}
