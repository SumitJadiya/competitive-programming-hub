package com.sumit.coding.design_patterns.structural.decorator.problem.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.problem.service.Pizza;

public class PizzaWithCheeseAndPepperoni extends Pizza {

    @Override
    public String getDescription() {
        return super.getDescription() + " + Cheese + Pepperoni";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.5;  // Cheese and Pepperoni cost extra
    }
}
