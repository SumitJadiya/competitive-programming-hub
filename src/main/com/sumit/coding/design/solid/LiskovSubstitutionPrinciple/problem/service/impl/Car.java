package com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.problem.service.impl;

import com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.problem.service.Vehicle;

public class Car extends Vehicle {
    @Override
    public Integer getNumberOfWheels() {
        return 4;
    }
}
