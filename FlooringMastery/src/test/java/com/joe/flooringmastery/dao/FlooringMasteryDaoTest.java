/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Flooring2;
import com.joe.flooringmastery.dto.StateTax;
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

/**
 *
 * @author joe
 */
public class FlooringMasteryDaoTest {

    private FlooringMasteryDao dao = new FlooringMasteryDaoFileImpl();

    public FlooringMasteryDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        List<Flooring> orderList = dao.getAllOrders();
        for (Flooring order : orderList) {
            dao.removeOrder(order.getOrderNumber());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testAddGetOrder() throws Exception {
    Flooring2.trainingOrProduction = ("t");
    Flooring flooring = new Flooring("15");
    String orderDateString = ("2020-10-05");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate orderDate = LocalDate.parse(orderDateString, formatter);
    flooring.setOrderDate(orderDate);
    flooring.setCustomerFirstName("Joe");
    flooring.setCustomerLastName("Smith");
    flooring.setProductType("Carpet");
    String areaString = ("100");
    BigDecimal area = (new BigDecimal("100"));
    flooring.setArea(area);
    flooring.setState("PA");
    flooring.setTaxRate(new BigDecimal(6.75));
    flooring.setCostPerSquareFoot(new BigDecimal("2.75"));
    flooring.setLaborCostPerSquareFoot(new BigDecimal("3.00"));
    flooring.setMaterialCost(new BigDecimal("1000"));
    flooring.setLaborCost(new BigDecimal("1000"));
    flooring.setTax(new BigDecimal("11.00"));
    flooring.setTotal(new BigDecimal ("2500.00"));
   
    dao.addOrder(flooring.getOrderNumber(), flooring);
   
    Flooring fromDao = dao.getOrder2(flooring.getOrderNumber());
   
    assertEquals(flooring, fromDao);
    }

    /**
     * Test of getAllOrders method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        
    Flooring2.trainingOrProduction = ("t");
    Flooring flooring1 = new Flooring("16");
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
    flooring1.setTotal(new BigDecimal ("2500.00"));
   
    dao.addOrder(flooring1.getOrderNumber(), flooring1);
   
    Flooring2.trainingOrProduction = ("p");
    Flooring flooring2 = new Flooring("17");
    String orderDateString2 = ("2020-12-05");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate orderDate2 = LocalDate.parse(orderDateString2, formatter2);
    flooring2.setOrderDate(orderDate);
    flooring2.setCustomerFirstName("Tammy");
    flooring2.setCustomerLastName("Smith");
    flooring2.setProductType("Carpet");
    BigDecimal area2 = (new BigDecimal("100"));
    flooring2.setArea(area2);
    flooring2.setState("PA");
    flooring2.setTaxRate(new BigDecimal(6.75));
    flooring2.setCostPerSquareFoot(new BigDecimal("2.75"));
    flooring2.setLaborCostPerSquareFoot(new BigDecimal("3.00"));
    flooring2.setMaterialCost(new BigDecimal("1000"));
    flooring2.setLaborCost(new BigDecimal("1000"));
    flooring2.setTax(new BigDecimal("11.00"));
    flooring2.setTotal(new BigDecimal ("4500.00"));
   
    dao.addOrder(flooring2.getOrderNumber(), flooring2);
   
    assertEquals(5, dao.getAllOrders().size());
    }

    /**
     * Test of getOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetOrder() {
    }

    /**
     * Test of getOrder2 method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetOrder2() {
    }

    /**
     * Test of getOrder3 method, of class FlooringMasteryDao.
     */
    @Test
    public void testGetOrder3() {
    }

    /**
     * Test of editOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of removeOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
    Flooring2.trainingOrProduction = ("t");
    Flooring flooring1 = new Flooring("18");
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
    flooring1.setTotal(new BigDecimal ("2500.00"));
   
    dao.addOrder(flooring1.getOrderNumber(), flooring1);
   
    Flooring2.trainingOrProduction = ("p");
    Flooring flooring2 = new Flooring("19");
    String orderDateString2 = ("2020-12-05");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate orderDate2 = LocalDate.parse(orderDateString2, formatter2);
    flooring2.setOrderDate(orderDate);
    flooring2.setCustomerFirstName("Tammy");
    flooring2.setCustomerLastName("Smith");
    flooring2.setProductType("Carpet");
    BigDecimal area2 = (new BigDecimal("100"));
    flooring2.setArea(area2);
    flooring2.setState("PA");
    flooring2.setTaxRate(new BigDecimal(6.75));
    flooring2.setCostPerSquareFoot(new BigDecimal("2.75"));
    flooring2.setLaborCostPerSquareFoot(new BigDecimal("3.00"));
    flooring2.setMaterialCost(new BigDecimal("1000"));
    flooring2.setLaborCost(new BigDecimal("1000"));
    flooring2.setTax(new BigDecimal("11.00"));
    flooring2.setTotal(new BigDecimal ("4500.00"));
   
    dao.addOrder(flooring2.getOrderNumber(), flooring2);
   
    dao.removeOrder(flooring1.getOrderNumber());
    assertEquals(4, dao.getAllOrders().size());
    assertNull(dao.getOrder2(flooring1.getOrderNumber()));
   
    dao.removeOrder(flooring2.getOrderNumber());
    assertEquals(3, dao.getAllOrders().size());
    assertNull(dao.getOrder2(flooring2.getOrderNumber()));
    }

    /**
     * Test of loadOrder method, of class FlooringMasteryDao.
     */
    @Test
    public void testLoadOrder() throws Exception {
    }

}
