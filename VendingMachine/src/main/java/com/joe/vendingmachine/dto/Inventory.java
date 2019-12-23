/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dto;

/**
 *
 * @author joe
 */
public class Inventory {
    private String name;
    private double cost;
    private int inStock;
    
    public Inventory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    public double getCost() {
        return cost;
    }

    
    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    
}
