package com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Drink;

public class Coke implements Drink {

    @Override
    public void pour() {
        System.out.println("Pouring Coke...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Coke...");
    }
}
