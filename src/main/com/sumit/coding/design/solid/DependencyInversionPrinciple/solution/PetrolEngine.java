package com.sumit.coding.design.solid.DependencyInversionPrinciple.solution;

public class PetrolEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol engine starting...");
    }
}
