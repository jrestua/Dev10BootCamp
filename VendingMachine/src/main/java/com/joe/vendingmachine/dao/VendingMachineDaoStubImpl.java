/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dao;

import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    //For unit testing purposes.
    //Different test cases to test out functionality of predefined methods.
    
    Inventory onlyItem;
    List<Inventory> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Inventory("Test Case", new BigDecimal("2.50"));
        onlyItem.setInStock(0);
        
        itemList.add(onlyItem);
    }
    
    @Override
    public List<Inventory> getAllItemsInInventory() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Inventory updateItemQuantity(String name, Inventory updatedQuantity) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public Inventory removeItem(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }
    
}
