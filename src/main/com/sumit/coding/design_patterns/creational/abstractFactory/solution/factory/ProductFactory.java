package com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;

public interface ProductFactory {
    Pizza createPizza(String type);
    Drink createDrink(String type);
}
