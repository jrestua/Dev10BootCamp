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

public class FlooringMasteryOrderValidationException extends Exception {
    
    public FlooringMasteryOrderValidationException(String message) {
        super(message);
    }
    
    public FlooringMasteryOrderValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
