/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.service;

/**
 *
 * @author joe
 */
public class SoldOutInventoryException extends Exception{
    
    public SoldOutInventoryException(String message) {
        super(message);
    }
    
    public SoldOutInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
