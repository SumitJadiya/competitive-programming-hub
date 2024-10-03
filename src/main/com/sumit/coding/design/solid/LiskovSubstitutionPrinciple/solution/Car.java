package com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.solution;

public class Car extends EngineVehicle {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}
