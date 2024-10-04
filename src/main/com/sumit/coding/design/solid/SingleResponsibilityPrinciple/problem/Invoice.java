package com.sumit.coding.design.solid.SingleResponsibilityPrinciple.problem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Invoice {
    private final String id;
    private final double amount;

    // Violation: Handles both data and printing responsibilities
    public void printInvoice() {
        System.out.println("Invoice ID: " + id);
        System.out.println("Amount: $" + amount);
    }
}
