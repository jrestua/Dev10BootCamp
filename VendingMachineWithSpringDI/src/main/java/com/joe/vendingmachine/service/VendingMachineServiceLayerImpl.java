/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.service;

import com.joe.vendingmachine.dao.VendingMachineAuditDao;
import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachinePersistenceException;
import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    
    private VendingMachineAuditDao auditDao;
    VendingMachineDao dao;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Inventory> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItemsInInventory();
    }

    @Override
    public void buyItem(int itemIndex, BigDecimal userMoney) throws
            VendingMachinePersistenceException,
            InsufficientFundsException, 
            SoldOutInventoryException {
        
        List<Inventory> items = dao.getAllItemsInInventory();
        Inventory item = items.get(itemIndex);
        
        if(userMoney.compareTo(item.getPrice()) < 0) {
            throw new InsufficientFundsException("Insufficient Funds.");
        }
        
        if(item.getInStock() < 1) {
            throw new SoldOutInventoryException("Item out of stock");
        }
        
        Inventory updatedItem = new Inventory(item.getName(), item.getPrice());
        updatedItem.setInStock(item.getInStock() - 1);
        dao.updateItemQuantity(updatedItem.getName(), updatedItem);
        auditDao.writeAuditEntry("Item " + item.getName() + " SOLD.");
    }
}

