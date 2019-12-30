/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.service;

import com.joe.vendingmachine.dao.VendingMachinePersistenceException;
import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author joe
 */
public interface VendingMachineServiceLayer {

    List<Inventory> getAllItems() throws VendingMachinePersistenceException;
    
    void buyItem(int itemIndex, BigDecimal userMoney) throws
            VendingMachinePersistenceException,
            InsufficientFundsException,
            SoldOutInventoryException;
    
}