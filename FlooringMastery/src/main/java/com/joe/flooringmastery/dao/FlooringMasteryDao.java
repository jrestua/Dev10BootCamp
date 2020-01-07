/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Flooring;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author joe
 */
public interface FlooringMasteryDao {

    Flooring addOrder(String orderNumber, Flooring order) throws FlooringMasteryPersistenceException;

    List<Flooring> getAllOrders() throws FlooringMasteryPersistenceException;

    List<Flooring> getOrder(LocalDate orderDate);

    Flooring getOrder2(String orderNumber);

    Flooring getOrder3(String orderNumber, LocalDate orderDate);

    Flooring editOrder(Flooring order) throws FlooringMasteryPersistenceException;

    Flooring removeOrder(String orderNumber) throws FlooringMasteryPersistenceException;

    void loadOrder() throws FlooringMasteryPersistenceException;

}
