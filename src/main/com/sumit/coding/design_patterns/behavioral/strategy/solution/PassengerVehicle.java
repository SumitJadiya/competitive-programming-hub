package com.sumit.coding.design_patterns.behavioral.strategy.solution;

import com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
