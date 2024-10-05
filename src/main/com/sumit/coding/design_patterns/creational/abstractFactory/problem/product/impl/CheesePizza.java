package com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Pizza;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Cheese Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Cheese Pizza...");
    }
}
