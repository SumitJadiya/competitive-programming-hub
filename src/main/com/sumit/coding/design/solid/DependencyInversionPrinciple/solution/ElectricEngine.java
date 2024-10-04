package com.sumit.coding.design.solid.DependencyInversionPrinciple.solution;

public class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric engine starting...");
    }
}
