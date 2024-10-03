package com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.problem;

public class Car extends Vehicle {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}
