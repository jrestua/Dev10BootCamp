/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dao;

import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joe
 */
public class VendingMachineDaoTest {
    
    VendingMachineDao dao = new VendingMachineDaoFileImpl();
    
    public VendingMachineDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
@BeforeEach
public void setUp() throws Exception {
    List<Inventory> inventoryList = dao.getAllItemsInInventory();
    for (Inventory inventory : inventoryList) {
        dao.removeItem(inventory.getName());
    }
}
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllItemsInInventory method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItemsInInventory() throws Exception {
    }

    /**
     * Test of updateItemQuantity method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateItemQuantity() throws Exception {
    }

    /**
     * Test of removeItem method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItem() throws Exception {
        Inventory item1 = new Inventory("Fruits", new BigDecimal(1.50));
        item1.setInStock(1);
        
        dao.updateItemQuantity(item1.getName(), item1);
        
        Inventory item2 = new Inventory("Chips", new BigDecimal(1.00));
        item1.setInStock(1);
        
        dao.updateItemQuantity(item2.getName(), item2);
        
        dao.removeItem(item1.getName());
        assertEquals(1,dao.getAllItemsInInventory().size());
        
        dao.removeItem(item2.getName());
        assertEquals(0,dao.getAllItemsInInventory().size());
        assertEquals(true, dao.getAllItemsInInventory().isEmpty());
        
    }

   
    
}
