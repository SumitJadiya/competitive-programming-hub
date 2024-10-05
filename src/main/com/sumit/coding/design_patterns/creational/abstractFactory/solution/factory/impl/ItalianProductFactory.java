package com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.ProductFactory;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.CheesePizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.Coke;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.PepperoniPizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.Pepsi;

public class ItalianProductFactory implements ProductFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }

    @Override
    public Drink createDrink(String type) {
        Drink drink = null;
        if (type.equals("coke")) {
            drink = new Coke();
        } else if (type.equals("pepsi")) {
            drink = new Pepsi();
        }
        return drink;
    }
}
