/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.service;

/**
 *
 * @author joe
 */

public class FlooringMasteryProductValidationException extends Exception {
    
    public FlooringMasteryProductValidationException(String message) {
        super(message);
    }
    
    public FlooringMasteryProductValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}