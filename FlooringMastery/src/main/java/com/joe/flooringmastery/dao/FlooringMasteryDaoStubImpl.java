/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Flooring2;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joe
 */
public class FlooringMasteryDaoStubImpl implements FlooringMasteryDao {

    private Flooring onlyOrder;
    private Flooring2 onlyOrder2;
    private List<Flooring> orderList = new ArrayList<>();

    public FlooringMasteryDaoStubImpl() {

        onlyOrder2.trainingOrProduction = ("p");
        onlyOrder = new Flooring("19");
        String orderDateString = ("2020-12-05");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.parse(orderDateString, formatter);
        onlyOrder.setOrderDate(orderDate);
        onlyOrder.setCustomerFirstName("Tammy");
        onlyOrder.setCustomerLastName("Smith");
        onlyOrder.setProductType("Carpet");
        BigDecimal area = (new BigDecimal("100"));
        onlyOrder.setArea(area);
        onlyOrder.setState("PA");
        onlyOrder.setTaxRate(new BigDecimal(6.75));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("2.75"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("3.00"));
        onlyOrder.setMaterialCost(new BigDecimal("1000"));
        onlyOrder.setLaborCost(new BigDecimal("1000"));
        onlyOrder.setTax(new BigDecimal("11.00"));
        onlyOrder.setTotal(new BigDecimal("4500.00"));

        orderList.add(onlyOrder);
    }

    @Override
    public Flooring addOrder(String orderNumber, Flooring order) throws FlooringMasteryPersistenceException {
        if (orderNumber.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Flooring> getAllOrders() throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Flooring> getOrder(LocalDate orderDate) {
        return orderList;
    }

    @Override
    public Flooring getOrder2(String orderNumber) {
        if (orderNumber.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Flooring getOrder3(String orderNumber, LocalDate orderDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flooring editOrder(Flooring order) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flooring removeOrder(String orderNumber) throws FlooringMasteryPersistenceException {
        if (orderNumber.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }   

    @Override
    public void loadOrder() throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
