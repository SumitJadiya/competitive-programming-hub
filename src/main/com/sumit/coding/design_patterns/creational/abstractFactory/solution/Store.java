package com.sumit.coding.design_patterns.creational.abstractFactory.solution;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.ProductFactory;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory.impl.ItalianProductFactory;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;

public class Store {

    public static void main(String[] args) {
        ProductFactory factory = new ItalianProductFactory(); // Choose Italian product family
        Pizza pizza = factory.createPizza("cheese");
        Drink drink = factory.createDrink("coke");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        drink.pour();
        drink.serve();
    }
}

/*
    Benefits of Abstract Factory Pattern:

	1.	Separation of Concerns: Each product family (Italian, Mexican, etc.) has its own factory, following the Single Responsibility Principle.
	2.	Flexibility: We can easily switch between product families (Italian, Mexican, etc.) by swapping the factory (e.g., ItalianProductFactory vs MexicanProductFactory) without modifying the core logic.
	3.	Open-Closed Principle: The system is open for extension but closed for modification. Adding new product families requires creating new factories, not changing the existing code.
	4.	Decoupling: The Store class is decoupled from specific product implementations. It only interacts with abstract interfaces and factories, making it easy to extend or modify.

    Summary:

    The problem code mixed the creation logic for different products in a single factory, leading to a lack of flexibility and violating SOLID principles.
    By introducing the Abstract Factory Pattern, we separated the creation logic for different product families and made the system more modular, flexible, and easier to maintain.
*/