package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.RestaurantUser;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.impl.Chef;

/*
 * The Interface Segregation Principle (ISP) states that a class should not be forced to implement interfaces it doesn’t use.
 * Instead, it’s better to create smaller, more specific interfaces to keep implementations focused on only the functionality that is necessary.
 * */
public class MainClass {

    public static void main(String[] args) {
        RestaurantUser chef = new Chef();

        chef.serveFood(); // irrelevant
        chef.orderFood(); // irrelevant
    }
}
