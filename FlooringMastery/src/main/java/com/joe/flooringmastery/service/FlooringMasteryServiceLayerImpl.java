/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.service;

import com.joe.flooringmastery.dao.FlooringMasteryAuditDao;
import com.joe.flooringmastery.dao.FlooringMasteryDao;
import com.joe.flooringmastery.service.FlooringMasteryInvalidOrderNumberException;
import com.joe.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.joe.flooringmastery.dao.ProductsDao;
import com.joe.flooringmastery.dao.StateTaxDao;
import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Products;
import com.joe.flooringmastery.dto.StateTax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joe
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    private FlooringMasteryAuditDao auditDao;
    private StateTaxDao stateTaxDao;
    private ProductsDao productsDao;
    FlooringMasteryDao dao;

    public FlooringMasteryServiceLayerImpl(FlooringMasteryDao dao, StateTaxDao stateTaxDao, ProductsDao productsDao, FlooringMasteryAuditDao auditDao) {
        this.dao = dao;
        this.stateTaxDao = stateTaxDao;
        this.productsDao = productsDao;
        this.auditDao = auditDao;
    }

    public void createOrder(Flooring order) throws
            FlooringMasteryDuplicateIdException,
            FlooringMasteryDataValidationException,
            FlooringMasteryPersistenceException {

        // First check to see if there is alreay a order 
        // associated with the given order's id
        // If so, we're all done here - 
        // throw a FlooringMasteryDuplicateIdException
        /*
        if (dao.getOrder2(order.getOrderNumber()) != null) {
            throw new FlooringMasteryDuplicateIdException(
                    "ERROR: Could not create order.  Order Number "
                    + order.getOrderNumber()
                    + " already exists");
        }
         */
        try {
            // Now validate all the fields on the given Order object.
            // This method will throw an
            // exception if any of the validation rules are violated.
            validateOrder(order);
        } catch (FlooringMasteryOrderValidationException ex) {
            Logger.getLogger(FlooringMasteryServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        // We passed all our business rules checks so go ahead 
        // and persist the Order object
        /*
        dao.addOrder(order.getOrderNumber(), order);

        // The order was successfully created, now write to the audit log
        auditDao.writeAuditEntry(
                "Student " + order.getOrderNumber() + " CREATED.");
         */
    }

    @Override
    public List<Flooring> getAllOrders() throws FlooringMasteryPersistenceException {
        return dao.getAllOrders();
    }

    public List<Flooring> getOrder(LocalDate orderDate) throws FlooringMasteryPersistenceException {
        List orders = dao.getOrder(orderDate);

        if (orders == null || orders.isEmpty()) {
            System.out.println("There are no orders placed on that date.");
        }

        return orders;
    }

    @Override
    public Flooring getOrder2(String orderNumber) throws FlooringMasteryPersistenceException {
        return dao.getOrder2(orderNumber);
    }

    /*
    @Override
    public List<Flooring> getTaxes(String state) throws FlooringMasteryPersistenceException {
        List taxes = dao.getTaxes(state);

        if (taxes == null || taxes.isEmpty()) {
            System.out.println("State is not available.");
        }

        return taxes;
    }

    @Override
    public List<Flooring> getProducts(String productType) throws FlooringMasteryPersistenceException {
        List products = dao.getProducts(productType);

        if (products == null || products.isEmpty()) {
            System.out.println("Product Type Does Not Exist.");
        }

        return products;
    }
     */
    @Override
    public Flooring removeOrder(String orderNumber) throws FlooringMasteryPersistenceException {
        Flooring removedOrder = dao.removeOrder(orderNumber);
        // Write to audit log
        auditDao.writeAuditEntry("Order " + orderNumber + " REMOVED.");
        return removedOrder;
    }

    @Override
    public Flooring editOrder(Flooring updatedOrder) throws FlooringMasteryPersistenceException, FlooringMasteryInvalidOrderNumberException {
        updatedOrder = dao.editOrder(updatedOrder);
        if (updatedOrder != null) {
            return updatedOrder;
        } else {
            throw new FlooringMasteryInvalidOrderNumberException("ERROR: No orders with that number exist on that date.");
        }
    }

    @Override
    public Flooring calculateOrder(Flooring order) throws FlooringMasteryPersistenceException,
            FlooringMasteryOrderValidationException, FlooringMasteryStateValidationException, FlooringMasteryProductValidationException {
        Flooring calculatedOrder;

        calculatedOrder = validateOrder(order);
        calculatedOrder = calculateTax(order);
        calculatedOrder = calculateMaterial(order);
        calculatedOrder = calculateTotal(order);
        dao.addOrder(order.getOrderNumber(), order);
        auditDao.writeAuditEntry(
                "Student " + order.getOrderNumber() + " CREATED.");
        return order;

    }

    private Flooring calculateTax(Flooring order) throws FlooringMasteryPersistenceException,
            FlooringMasteryStateValidationException {

        String chosenState = order.getState();

        StateTax myState = stateTaxDao.getStateName(chosenState);
//        BigDecimal tax = stateDao.getTaxRate();
        if (myState == null) {
            throw new FlooringMasteryStateValidationException("ERROR: No State Found! ");
        } else {
            String state = myState.getState();
            BigDecimal taxRate = myState.getTaxRate();
            order.setState(state);
            order.setTaxRate(taxRate);
        }
        return order;
    }

    private Flooring calculateMaterial(Flooring order) throws FlooringMasteryPersistenceException,
            FlooringMasteryProductValidationException {
        Products chosenProduct = productsDao.getProduct(order.getProductType());
        if (chosenProduct == null) {
            throw new FlooringMasteryProductValidationException("ERROR: We do not sell that product.");
        }
        order.setProductType(chosenProduct.getProductType());
        order.setCostPerSquareFoot(chosenProduct.getCostPerSquareFoot());
        order.setLaborCostPerSquareFoot(chosenProduct.getLaborCostPerSquareFoot());

        return order;
    }

    private Flooring calculateTotal(Flooring order) {
        order.setMaterialCost(order.getCostPerSquareFoot().multiply(order.getArea())
                .setScale(2, RoundingMode.HALF_UP));
        order.setLaborCost(order.getLaborCostPerSquareFoot().multiply(order.getArea())
                .setScale(2, RoundingMode.HALF_UP));
        order.setTax(order.getTaxRate().divide(new BigDecimal("100.00"))
                .multiply((order.getMaterialCost().add(order.getLaborCost())))
                .setScale(2, RoundingMode.HALF_UP));
        order.setTotal(order.getMaterialCost().add(order.getLaborCost()).add(order.getTax()));

        return order;
    }

    private Flooring validateOrder(Flooring order) throws FlooringMasteryOrderValidationException {
        String message = "";
        if (order.getCustomerLastName().trim().isEmpty() || order.getCustomerLastName() == null) {
            message += "Customer first name is required.\n";
        }
        if (order.getCustomerFirstName().trim().isEmpty() || order.getCustomerFirstName() == null) {
            message += "Customer last name is required.\n";
        }
        if (order.getState().trim().isEmpty() || order.getState() == null) {
            message += "State is required.\n";
        }
        if (order.getProductType().trim().isEmpty() || order.getProductType() == null) {
            message += "Product type is required.\n";
        }
        if (order.getArea().compareTo(BigDecimal.ZERO) == 0 || order.getArea() == null) {
            message += "Area square footage is required.";
        }
        if (!message.isEmpty()) {
            throw new FlooringMasteryOrderValidationException(message);
        }

        return order;
    }

    @Override
    public Flooring compareOrders(Flooring savedOrder, Flooring editedOrder) throws FlooringMasteryPersistenceException, FlooringMasteryStateValidationException, FlooringMasteryProductValidationException {
        if (editedOrder.getCustomerFirstName() == null || editedOrder.getCustomerFirstName().trim().equals("")) {
        } else {
            savedOrder.setCustomerFirstName(editedOrder.getCustomerFirstName());
        }

        if (editedOrder.getCustomerLastName() == null || editedOrder.getCustomerLastName().trim().equals("")) {
        } else {
            savedOrder.setCustomerLastName(editedOrder.getCustomerLastName());
        }

        if (editedOrder.getState() == null
                || editedOrder.getState().trim().equals("")) {
        } else {
            savedOrder.setState(editedOrder.getState());
            calculateTax(savedOrder);
        }

        if (editedOrder.getProductType() == null
                || editedOrder.getProductType().equals("")) {
        } else {
            savedOrder.setProductType(editedOrder.getProductType());

            calculateMaterial(savedOrder);
        }

        if (editedOrder.getArea() == null
                || (editedOrder.getArea().compareTo(BigDecimal.ZERO)) == 0) {
        } else {
            savedOrder.setArea(editedOrder.getArea());
        }
        calculateTotal(savedOrder);
        return savedOrder;
    }

}
