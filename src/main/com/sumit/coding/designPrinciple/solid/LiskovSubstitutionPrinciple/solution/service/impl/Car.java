package com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.EngineVehicle;

public class Car extends EngineVehicle {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}
