package com.sumit.coding.design.solid.SingleResponsibilityPrinciple.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Invoice {
    private final String id;
    private final double amount;
}
