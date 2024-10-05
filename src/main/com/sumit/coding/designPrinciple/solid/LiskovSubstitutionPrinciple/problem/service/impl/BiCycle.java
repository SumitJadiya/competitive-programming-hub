package com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.problem.service.impl;

import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.problem.service.Vehicle;

public class BiCycle extends Vehicle {
    @Override
    public Boolean hasEngine() {
        return null;
    }
}
