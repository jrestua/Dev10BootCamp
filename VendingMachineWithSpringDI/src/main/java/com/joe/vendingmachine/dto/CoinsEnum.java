/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author joe
 */
public enum CoinsEnum {
    
    //Used for Enum constants. 
    
    PENNY(new BigDecimal("0.01")),
    NICKEL(new BigDecimal("0.05")),
    DIME(new BigDecimal("0.10")),
    QUARTER(new BigDecimal("0.25"));

    private BigDecimal value;

    private CoinsEnum(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return this.value;
    }
}
