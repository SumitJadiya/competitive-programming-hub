package com.sumit.coding.designPrinciple.solid.SingleResponsibilityPrinciple.solution;

public class MainClass {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("INV001", 500.00);
        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();
    }
}