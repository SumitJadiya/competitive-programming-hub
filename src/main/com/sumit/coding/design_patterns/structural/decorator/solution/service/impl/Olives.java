package com.sumit.coding.design_patterns.structural.decorator.solution.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.solution.service.Pizza;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.ToppingDecorator;

public class Olives extends ToppingDecorator {

    public Olives(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " + Olives";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 1.0;  // Olives cost extra
    }
}
