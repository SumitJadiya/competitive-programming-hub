package com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Drink;

public class Pepsi implements Drink {

    @Override
    public void pour() {
        System.out.println("Pouring Coke...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Coke...");
    }
}
