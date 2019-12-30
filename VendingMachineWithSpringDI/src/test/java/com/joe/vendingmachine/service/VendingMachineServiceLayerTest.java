/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.service;

import com.joe.vendingmachine.dao.VendingMachineAuditDao;
import com.joe.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.joe.vendingmachine.dao.VendingMachinePersistenceException;
import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author joe
 */
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerTest() {
        //VendingMachineDao dao = new VendingMachineDaoStubImpl();
        //VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
        
        //service = new VendingMachineServiceLayerImpl(dao, auditDao);
        
        //instantiates the application context, retrieves the Controller 
        //from the context, and then invokes the run method on the Controller.
        
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            service =  ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, service.getAllItems().size());
    }

    /**
     * Test of buyItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testBuyItem() throws Exception {
    }
    
}
