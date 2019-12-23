/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dao;

import com.joe.vendingmachine.dto.Inventory;
import java.util.List;

/**
 *
 * @author joe
 */
public interface VendingMachineDao {
    
    List<Inventory> getAllItemsInInventory() throws VendingMachinePersistenceException;
    
    Inventory updateItemQuantity(String name, Inventory newQuantity) throws VendingMachinePersistenceException;
    
    Inventory removeItem(String name) throws VendingMachinePersistenceException;    
}
