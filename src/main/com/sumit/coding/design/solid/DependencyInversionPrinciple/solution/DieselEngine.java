package com.sumit.coding.design.solid.DependencyInversionPrinciple.solution;

public class DieselEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Diesel engine starting...");
    }
}
