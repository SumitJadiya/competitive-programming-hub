package com.sumit.coding.designPrinciple.solid.SingleResponsibilityPrinciple.solution;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvoicePrinter {
    private final Invoice invoice;

    public void printInvoice() {
        System.out.println("invoice ID: " + invoice.getId());
        System.out.println("Amount: " + invoice.getAmount());
    }
}
