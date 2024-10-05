package com.sumit.coding.design_patterns.creational.abstractFactory.problem;

import com.sumit.coding.design_patterns.creational.abstractFactory.problem.factory.ProductFactory;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Pizza;

public class PizzaStore {

    public static void main(String[] args) {
        Pizza pizza = ProductFactory.createPizza("cheese");
        Drink drink = ProductFactory.createDrink("coke");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        drink.pour();
        drink.serve();
    }
}

/*
    Problems with This Code:

	1.	Tight Coupling: The ProductFactory handles the creation of both pizza and drinks in a single class, violating the Single Responsibility Principle.
	2.	Complexity: As the number of product types grows, the ProductFactory becomes harder to maintain.
	3.	Lack of Flexibility: It’s hard to switch to another family of products (e.g., from Italian to Mexican pizzas and drinks) without modifying the factory.
* */