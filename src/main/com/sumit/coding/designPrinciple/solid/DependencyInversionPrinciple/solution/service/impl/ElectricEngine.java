package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.Engine;

public class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }
}
