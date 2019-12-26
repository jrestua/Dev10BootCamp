/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author joe
 */
public class Inventory {
    
    //Variables are declared with getters and setters to be used throughout program.
    //Used for retrieving and updating the data. 
    
    private String name;
    private BigDecimal price;
    private int inStock;
    
    public Inventory(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    } 
    
    public String getName() {
        return this.name;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public int getInStock() {
        return this.inStock;
    }
    
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.price);
        hash = 97 * hash + this.inStock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory inv = (Inventory) obj;
        if (this.inStock != inv.inStock) {
            return false;
        }
        if (!Objects.equals(this.name, inv.name)) {
            return false;
        }
        if (!Objects.equals(this.price, inv.price)) {
            return false;
        }
        return true;
    }
    
    
}
