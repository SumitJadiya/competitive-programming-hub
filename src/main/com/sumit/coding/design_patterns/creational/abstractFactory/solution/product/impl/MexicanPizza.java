package com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;

public class MexicanPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veggie Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Veggie Pizza...");
    }
}