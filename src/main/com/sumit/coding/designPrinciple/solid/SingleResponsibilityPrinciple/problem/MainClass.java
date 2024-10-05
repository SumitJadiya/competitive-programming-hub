package com.sumit.coding.designPrinciple.solid.SingleResponsibilityPrinciple.problem;

/*
 * 	•	Definition:
 *      A class should have only one reason to change, meaning it should have only one job or responsibility.
 *
 * 	•	Explanation:
 *      Each class should do only one thing. If a class does too many things,
 *      changes in one area can lead to unintended effects in other areas, making the code harder to maintain.
 * 	•
 *      Example:
 *      A class that handles both business logic and database operations violates this principle.
 *      Instead, you should separate them into different classes.
 * */
public class MainClass {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("INV001", 500.00);
        invoice.printInvoice();
    }
}