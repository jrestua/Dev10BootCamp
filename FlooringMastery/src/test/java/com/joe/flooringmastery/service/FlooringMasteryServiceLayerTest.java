/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.service;

import com.joe.flooringmastery.dao.FlooringMasteryAuditDao;
import com.joe.flooringmastery.dao.FlooringMasteryAuditDaoFileImpl;
import com.joe.flooringmastery.dao.FlooringMasteryAuditDaoStubImpl;
import com.joe.flooringmastery.dao.FlooringMasteryDao;
import com.joe.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.joe.flooringmastery.dao.FlooringMasteryDaoStubImpl;
import com.joe.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.joe.flooringmastery.dao.ProductsDao;
import com.joe.flooringmastery.dao.ProductsDaoFileImpl;
import com.joe.flooringmastery.dao.StateTaxDao;
import com.joe.flooringmastery.dao.StateTaxDaoFileImpl;
import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Flooring2;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class FlooringMasteryServiceLayerTest {

    private FlooringMasteryServiceLayer service;

    public FlooringMasteryServiceLayerTest() {
        /*
        FlooringMasteryDao myDao = new FlooringMasteryDaoFileImpl();
        StateTaxDao stateTaxDao = new StateTaxDaoFileImpl();
        ProductsDao productsDao = new ProductsDaoFileImpl();
        FlooringMasteryAuditDao myAuditDao = new FlooringMasteryAuditDaoFileImpl();

        service = new FlooringMasteryServiceLayerImpl(myDao, stateTaxDao, productsDao, myAuditDao);
         */

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("serviceLayer", FlooringMasteryServiceLayer.class);
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
     * Test of createOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCreateOrder() throws Exception {
        Flooring2.trainingOrProduction = ("t");
        Flooring flooring1 = new Flooring("1");
        String orderDateString = ("2020-10-15");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.parse(orderDateString, formatter);
        flooring1.setOrderDate(orderDate);
        flooring1.setCustomerFirstName("Joe");
        flooring1.setCustomerLastName("Smith");
        flooring1.setProductType("Carpet");
        BigDecimal area = (new BigDecimal("100"));
        flooring1.setArea(area);
        flooring1.setState("PA");
        flooring1.setTaxRate(new BigDecimal(6.75));
        flooring1.setCostPerSquareFoot(new BigDecimal("2.75"));
        flooring1.setLaborCostPerSquareFoot(new BigDecimal("3.00"));
        flooring1.setMaterialCost(new BigDecimal("1000"));
        flooring1.setLaborCost(new BigDecimal("1000"));
        flooring1.setTax(new BigDecimal("11.00"));
        flooring1.setTotal(new BigDecimal("2500.00"));

        service.createOrder(flooring1);
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        assertEquals(1, service.getAllOrders().size());
    }

    /**
     * Test of getOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
        /*
        Flooring order = service.getOrder2("1");
        assertNotNull(order);
        order = service.getOrder2("1");
        assertNull(order);
         */
    }

    /**
     * Test of getOrder2 method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetOrder2() throws Exception {
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        /*
        Flooring order = service.removeOrder("1");
        assertNotNull(order);
        order = service.removeOrder("9999");
        assertNull(order);
         */
    }

    /**
     * Test of editOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of compareOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCompareOrders() throws Exception {
    }

    /**
     * Test of calculateOrder method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testCalculateOrder() throws Exception {
    }

}
