/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author joe
 */
public class StateTax {
    
    private String state;
    private BigDecimal taxRate;

    public StateTax(String state, BigDecimal taxRate) {
        this.state = state;
         this.taxRate = taxRate;
    }

    public StateTax() {
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
    
    
}
