package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.Engine;

public class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol engine starting...");
    }
}
