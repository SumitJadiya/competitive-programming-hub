package com.sumit.coding.design_patterns.behavioral.strategy.solution;

import com.sumit.coding.design_patterns.behavioral.strategy.solution.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
