package com.sumit.coding.design_patterns.structural.decorator.solution.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.solution.service.Pizza;

public class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 8.0;  // Base price for plain pizza
    }
}