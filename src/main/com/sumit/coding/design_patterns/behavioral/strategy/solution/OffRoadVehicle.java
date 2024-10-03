package com.sumit.coding.design_patterns.behavioral.strategy.solution;

import com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
