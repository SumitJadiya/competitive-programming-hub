package com.sumit.coding.design_patterns.structural.decorator.problem.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.problem.service.Pizza;

public class PizzaWithCheese extends Pizza {

    @Override
    public String getDescription() {
        return super.getDescription() + " + Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;  // Cheese costs extra
    }
}