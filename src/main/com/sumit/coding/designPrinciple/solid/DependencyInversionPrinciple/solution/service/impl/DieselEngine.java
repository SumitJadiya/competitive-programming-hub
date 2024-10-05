package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.Engine;

public class DieselEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Diesel engine starting...");
    }
}
