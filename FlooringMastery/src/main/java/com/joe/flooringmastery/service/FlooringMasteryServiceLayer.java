/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.service;

import com.joe.flooringmastery.service.FlooringMasteryInvalidOrderNumberException;
import com.joe.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.joe.flooringmastery.dto.Flooring;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author joe
 */
public interface FlooringMasteryServiceLayer {

    void createOrder(Flooring order) throws
            FlooringMasteryDuplicateIdException,
            FlooringMasteryDataValidationException,
            FlooringMasteryPersistenceException;

    List<Flooring> getAllOrders() throws FlooringMasteryPersistenceException ;

    List<Flooring> getOrder(LocalDate orderDate) throws
            FlooringMasteryPersistenceException;

    Flooring getOrder2(String orderNumber) throws
            FlooringMasteryPersistenceException;

    Flooring removeOrder(String orderNumber) throws
            FlooringMasteryPersistenceException;

    Flooring editOrder(Flooring updatedOrder) throws FlooringMasteryPersistenceException, FlooringMasteryInvalidOrderNumberException;
    
    Flooring compareOrders(Flooring savedOrder, Flooring editedOrder)
            throws FlooringMasteryPersistenceException, FlooringMasteryStateValidationException,
            FlooringMasteryProductValidationException;
    
    Flooring calculateOrder(Flooring order) throws FlooringMasteryPersistenceException,
            FlooringMasteryOrderValidationException, FlooringMasteryStateValidationException, FlooringMasteryProductValidationException;
    
   
}
