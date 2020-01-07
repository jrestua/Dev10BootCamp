/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Flooring2;
import com.joe.flooringmastery.ui.FlooringMasteryView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author joe
 */
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {

    private Map<String, Flooring> orders = new HashMap<>();

    public static final String ORDER_TRAINING_FILE = "ordersT.txt";
    public static final String ORDER_PRODUCTION_FILE = "ordersP.txt";
    
    public static final String DELIMITER = "::";

    @Override
    public Flooring addOrder(String orderNumber, Flooring order)
            throws FlooringMasteryPersistenceException {
        loadOrder();
        Flooring newOrder = orders.put(orderNumber, order);
        writeOrder();
        return newOrder;
    }
    

    @Override
    public List<Flooring> getAllOrders()
            throws FlooringMasteryPersistenceException {
        loadOrder();
        return new ArrayList(orders.values());
    }

    @Override
    public List<Flooring> getOrder(LocalDate orderDate) {
        return orders.values()
                .stream()
                .filter(s -> s.getOrderDate().equals(orderDate))
                .collect(Collectors.toList());
    }
   /*
        @Override
    public Flooring editOrder(String orderNumber, Flooring flooring)
           {
        Flooring editedOrder = orders.replace(orderNumber, flooring);
        return editedOrder;
    }
*/
    
    @Override
public Flooring editOrder(Flooring editedOrder) throws FlooringMasteryPersistenceException {

    String orderNumber = editedOrder.getOrderNumber();

    orders.put(orderNumber, editedOrder);

    writeOrder();
    
    return editedOrder;
}

    @Override
    public Flooring getOrder2(String orderNumber) {
        return orders.get(orderNumber);
    }
    
    @Override
    public Flooring getOrder3(String orderNumber, LocalDate Date) {
        return orders.get(orderNumber);
    }
    

    @Override
    public Flooring removeOrder(String orderNumber)
            throws FlooringMasteryPersistenceException {
        loadOrder();
        Flooring removedOrder = orders.remove(orderNumber);
        writeOrder();
        return removedOrder;
    }

    private Flooring unmarshallOrder(String orderAsText) {

        String[] orderTokens = orderAsText.split(DELIMITER);

        String orderNumber = orderTokens[0];

        Flooring orderFromFile = new Flooring(orderNumber);

        orderFromFile.setOrderDate(LocalDate.parse(orderTokens[1]));

        orderFromFile.setCustomerFirstName(orderTokens[2]);

        orderFromFile.setCustomerLastName(orderTokens[3]);

        orderFromFile.setState(orderTokens[4]);
        
        orderFromFile.setTaxRate(new BigDecimal(orderTokens[5]));
        
        orderFromFile.setProductType(orderTokens[6]);
        
        orderFromFile.setArea(new BigDecimal(orderTokens[7]));
        
        orderFromFile.setCostPerSquareFoot(new BigDecimal(orderTokens[8]));

        orderFromFile.setLaborCostPerSquareFoot(new BigDecimal(orderTokens[9]));
        
        orderFromFile.setMaterialCost(new BigDecimal(orderTokens[10]));
        
        orderFromFile.setLaborCost(new BigDecimal(orderTokens[11]));
        
        orderFromFile.setTax(new BigDecimal(orderTokens[12]));
        
        orderFromFile.setTotal(new BigDecimal(orderTokens[13]));      

        return orderFromFile;
    }


    



    public void loadOrder() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        if (Flooring2.trainingOrProduction.equals("t")) {
            try {
                // Create Scanner for reading the file
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(ORDER_TRAINING_FILE)));
            } catch (FileNotFoundException e) {
                throw new FlooringMasteryPersistenceException(
                        "-_- Could not load order data into memory.", e);
            }
            String currentLine;

            Flooring currentOrder;

            while (scanner.hasNextLine()) {

                currentLine = scanner.nextLine();

                currentOrder = unmarshallOrder(currentLine);

                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }

            scanner.close();
        }
        if (Flooring2.trainingOrProduction.equals("p")) {
            try {
                // Create Scanner for reading the file
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(ORDER_PRODUCTION_FILE)));
            } catch (FileNotFoundException e) {
                throw new FlooringMasteryPersistenceException(
                        "-_- Could not load order data into memory.", e);
            }
            String currentLine;

            Flooring currentOrder;

            while (scanner.hasNextLine()) {

                currentLine = scanner.nextLine();

                currentOrder = unmarshallOrder(currentLine);

                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }

            scanner.close();
        }
    }

    private String marshallOrder(Flooring aOrder) {

        String orderAsText = aOrder.getOrderNumber() + DELIMITER;

        orderAsText += aOrder.getOrderDate() + DELIMITER;

        orderAsText += aOrder.getCustomerFirstName() + DELIMITER;

        orderAsText += aOrder.getCustomerLastName() + DELIMITER;

        orderAsText += aOrder.getState() + DELIMITER;
        
        orderAsText += aOrder.getTaxRate() + DELIMITER;
        
        orderAsText += aOrder.getProductType() + DELIMITER;
        
        orderAsText += aOrder.getArea() + DELIMITER;
        
        orderAsText += aOrder.getCostPerSquareFoot() + DELIMITER;
        
        orderAsText += aOrder.getLaborCostPerSquareFoot() + DELIMITER;
        
        orderAsText += aOrder.getMaterialCost() + DELIMITER;
        
        orderAsText += aOrder.getLaborCost() + DELIMITER;
        
        orderAsText += aOrder.getTax() + DELIMITER;
        
        orderAsText += aOrder.getTotal();

        return orderAsText;
    }

    private void writeOrder() throws FlooringMasteryPersistenceException {
        PrintWriter out;
        if (Flooring2.trainingOrProduction.equals("t")) {
            try {
                out = new PrintWriter(new FileWriter(ORDER_TRAINING_FILE));
            } catch (IOException e) {
                throw new FlooringMasteryPersistenceException(
                        "Could not save order data.", e);
            }

            String orderAsText;
            List<Flooring> orderList = this.getAllOrders();
            for (Flooring currentOrder : orderList) {
                orderAsText = marshallOrder(currentOrder);
                out.println(orderAsText);
                out.flush();
            }
            out.close();
        }
        if (Flooring2.trainingOrProduction.equals("p")) {
            try {
                out = new PrintWriter(new FileWriter(ORDER_PRODUCTION_FILE));
            } catch (IOException e) {
                throw new FlooringMasteryPersistenceException(
                        "Could not save order data.", e);
            }

            String orderAsText;
            List<Flooring> orderList = this.getAllOrders();
            for (Flooring currentOrder : orderList) {
                orderAsText = marshallOrder(currentOrder);
                out.println(orderAsText);
                out.flush();
            }
            out.close();
        }
    }

}
