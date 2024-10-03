package com.sumit.coding.design_patterns.behavioral.strategy.solution;

import com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
