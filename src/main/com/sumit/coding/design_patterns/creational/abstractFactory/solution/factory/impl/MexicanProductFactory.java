package com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.impl;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.ProductFactory;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.Horchata;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.MexicanPizza;

public class MexicanProductFactory implements ProductFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("mexican")) {
            pizza = new MexicanPizza();
        }
        return pizza;
    }

    @Override
    public Drink createDrink(String type) {
        Drink drink = null;
        if (type.equals("horchata")) {
            drink = new Horchata();
        }
        return drink;
    }
}
