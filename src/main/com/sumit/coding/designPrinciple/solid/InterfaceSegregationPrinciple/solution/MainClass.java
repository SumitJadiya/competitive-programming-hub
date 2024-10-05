package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.Cookable;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.Orderable;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.Serveable;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.impl.Chef;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.impl.Customer;
import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.impl.Waiter;

/*
 * The Interface Segregation Principle (ISP) states that a class should not be forced to implement interfaces it doesn’t use.
 * Instead, it’s better to create smaller, more specific interfaces to keep implementations focused on only the functionality that is necessary.
 * */
public class MainClass {
    public static void main(String[] args) {
        // Creating objects for Customer, Chef, and Waiter
        Orderable customer = new Customer();
        Cookable chef = new Chef();
        Serveable waiter = new Waiter();

        // Simulating a real-life scenario
        customer.orderFood();   // Customer orders food
        chef.cookFood();        // Chef cooks the food
        waiter.serveFood();     // Waiter serves the food
    }
}
