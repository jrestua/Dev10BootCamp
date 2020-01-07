/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.ui;

import com.joe.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Flooring2;
import com.joe.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.joe.flooringmastery.service.FlooringMasteryServiceLayer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author joe
 */
public class FlooringMasteryView {

    private UserIO io;
    private FlooringMasteryServiceLayer service;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
        this.service = service;
    }

    //Prints first menu.
    public int printMenuAndGetSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("Flooring Program");
        io.print("1. Enter Training Mode");
        io.print("2. Enter Production Mode");
        io.print("3. Quit Program");
        try {
            return io.readInt("Please select from the above choices (1-3).", 1, 3);
        } catch (NumberFormatException e) {
            io.print("Invalid Input");
            return 0;
        }
    }

    //Prints second menu. Training Mode.
    public int printMenuAndGetSelectionSecondMenu() {
        io.print("Flooring Program");
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Display An Order");
        io.print("6. Quit");
        try {
            return io.readInt("Please select from the above choices (1-6).", 1, 6);
        } catch (NumberFormatException e) {
            io.print("Invalid Input");
            return 0;
        }
    }

    public void displayTrainingModeBanner() {
        io.print("* * * * * ");
        io.print("Training Mode");
        io.print("* * * * * ");
    }

    public void displayProductionModeBanner() {
        io.print("* * * * * ");
        io.print("Production Mode");
        io.print("* * * * * ");
    }

    Flooring2 flooringTrainingOrProduction = new Flooring2();

    public String trainingModeReadWrite() {
        flooringTrainingOrProduction.setTrainingOrProduction("t");
        String training = "t";
        return training;
    }
    
        public String resetModeReadWrite() {
        flooringTrainingOrProduction.setTrainingOrProduction("");
        String training = "";
        return training;
    }

    public String productionModeReadWrite() {
        flooringTrainingOrProduction.setTrainingOrProduction("p");
        String production = "p";
        return production;
    }

    public void displayExitBanner() {
        io.print("Thank you. Come again");
    }

    public Flooring getNewOrderInfo(int orderNumberMax) throws FlooringMasteryDuplicateIdException {
        boolean keepGoing = true;
        Flooring currentOrder = null;
        while (keepGoing == true) {
            int orderNumberInt = orderNumberMax;
            orderNumberInt++;
            String orderNumber = Integer.toString(orderNumberInt);

            LocalDate orderDate = null;
            boolean isAfter = false;
            do {

                try {
                    String orderDateString = io.readString("Please Present or Future Order Date. (yyyy-MM-dd): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    orderDate = LocalDate.parse(orderDateString, formatter);
                    isAfter = orderDate.isAfter(LocalDate.now());
                } catch (DateTimeParseException e) {
                    io.print("Please enter a correct date.");

                }

            } while (orderDate == null || isAfter == false);
            //LocalDate orderDate = inputDate2();

            //Gets Valid First Name
            String customerFirstName = "";
            do {
                customerFirstName = io.readString("Please enter Customer First Name");
            } while ((customerFirstName.contains(":")) || customerFirstName.equals("") || customerFirstName.equals(null));

            //Gets Valid Last Name
            String customerLastName = "";
            do {
                customerLastName = io.readString("Please enter Customer Last Name");
            } while ((customerLastName.contains(":")) || customerLastName.equals("") || customerLastName.equals(null));

            //Get Product Type
            String productType = null;
            do {
            productType = io.readString("Please enter Product Type (Carpet/Laminate/Tile/Wood)");
            }
            while((productType == null) || (!(productType.equals("Carpet"))) && (!(productType.equals("Laminate"))) && (!(productType.equals("Tile"))) && (!(productType.equals("Wood"))));
            
            BigDecimal area = io.readBigDecimal("Please enter Area you would Like", 2, BigDecimal.ZERO);

                       
            //Get State
            String state = null;
            do {
            state = io.readString("What State do you live in? (Ex. OH/PA/MI/IN)");
            }
            while((state == null) || (!(state.equals("OH"))) && (!(state.equals("PA"))) && (!(state.equals("MI"))) && (!(state.equals("IN"))));
            

            io.print("Order Number: " + orderNumber);
            io.print("Order Date: " + orderDate);
            io.print("First Name: " + customerFirstName);
            io.print("Last Name: " + customerLastName);
            io.print("State: " + state);
            io.print("Product Type: " + productType);
            io.print("Area: " + area);
            String yesOrNo = io.readString("Please Verify If Information Is Correct: (y/n)");

            if (yesOrNo.equals("y")) {
                currentOrder = new Flooring(orderNumber);
                currentOrder.setOrderDate(orderDate);
                currentOrder.setCustomerFirstName(customerFirstName);
                currentOrder.setCustomerLastName(customerLastName);

                currentOrder.setArea(area);
                currentOrder.setProductType(productType);
                currentOrder.setState(state);

                keepGoing = false;
            } else {
                io.print("Re-Enter Information.");
                keepGoing = true;
            }
        }

        return currentOrder;
    }

    public void displayOrderList(List<Flooring> orderList) {
        for (Flooring currentOrder : orderList) {
            io.print("Order Number: " + currentOrder.getOrderNumber() + ": "
                    + "Order Date:" + currentOrder.getOrderDate() + " || "
                    + "First Name:" + currentOrder.getCustomerFirstName() + " || "
                    + "Last Name:" + currentOrder.getCustomerLastName() + " || "
                    + "States:" + currentOrder.getState() + " || "
                    + "Product Type:" + currentOrder.getProductType() + " || "
                    + "Area:" + currentOrder.getArea() + " || "
                    + "Total:" + currentOrder.getTotal() + " || ");
        }
        io.readString("Please hit enter to continue.");
    }

    public int getMaxOrderNumber(List<Flooring> orderList) {
        List<Integer> list = new ArrayList<Integer>();
        for (Flooring currentOrder : orderList) {
            String orderNumberString = currentOrder.getOrderNumber();
            int orderNumber = Integer.parseInt(orderNumberString);
            list.add(orderNumber);
        }
        return Collections.max(list);
    }

    public LocalDate inputDate2() {
        return io.readLocalDate("Please Enter Date in format yyyy-MM-dd", LocalDate.now());
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayOrder(List<Flooring> list) {

        if (list != null) {

            for (Flooring order : list) {
                io.print("");
                io.print("Order Number #: " + order.getOrderNumber());
                io.print("Customer Name: " + order.getCustomerFirstName() + " " + order.getCustomerLastName());
                io.print("Order Date: " + order.getOrderDate());
                io.print("State: " + order.getState() + " || " + "Tax Rate: " + order.getTaxRate());
                io.print("Product Type: " + order.getProductType() + " || " + "Area: " + order.getArea() + " || " + "Cost Per Square Foot: " + order.getCostPerSquareFoot()
                        + " || " + "Labor Cost Per Square Foot: " + order.getLaborCostPerSquareFoot());
                io.print("Material Cost: " + order.getMaterialCost() + " || " + "Labor Cost: " + order.getLaborCost());
                io.print("Tax: " + order.getTax() + " || " + "Total: " + order.getTotal());
                io.print("");

            }

        } else {
            io.print("No Orders were placed.");
        }
        io.print("Please hit enter to continue.");
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayEditOrderBanner() {
        io.print("=== Edit Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }

    public String getOrderNumberChoice() {
        return io.readString("Please enter the Order Number.");
    }

    public LocalDate inputDate() {
        String orderDateString = io.readString("Please Enter Order Date (yyyy/MM/dd): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.parse(orderDateString, formatter);
        return orderDate;
    }

    public LocalDate getOrderDateChoice() {
        String orderDateString = io.readString("Please enter the Date of the Order. (yyyy-MM-dd)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.parse(orderDateString, formatter);
        return orderDate;
    }

    public Flooring editOrder(Flooring order) {
        Flooring editedOrder = new Flooring();

        io.print("Customer First Name: " + order.getCustomerFirstName());
        editedOrder.setCustomerFirstName(inputCustomerFirstName());

        io.print("Customer Last Name: " + order.getCustomerLastName());
        editedOrder.setCustomerLastName(inputCustomerLastName());

        io.print("State Name (Ex. NC): " + order.getState());
        editedOrder.setState(inputStateName());

        io.print("Product Type: " + order.getProductType());
        editedOrder.setProductType(inputProductType());

        io.print("Area: " + order.getArea() + " sq ft");
        editedOrder.setArea(inputArea());

        return editedOrder;
    }

    public String inputCustomerFirstName() {
        return io.readString("Please enter customer first name.");
    }

    public String inputCustomerLastName() {
        return io.readString("Please enter customer last name.");
    }

    public String inputStateName() {
        return io.readString("Please enter your state's abbreviation. "
                + "(Ex. OH/PA/MI/IN)");
    }

    public String askSave() {
        return io.readString("Would you like to save. (y/n) ");
    }

    public String inputProductType() {
        return io.readString("Please enter the product you will be using (Wood/Carpet/Laminate/Tile).");
    }

    public BigDecimal inputArea() {
        return io.readBigDecimal("Please enter the area of your project "
                + "in square feet.", 2, BigDecimal.ZERO);
    }

    public void displayNewOrderBanner() {
        io.print("=== Add New Order ===");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Orders ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Order successfully created.  Please hit enter to continue");
    }

    public void displayEditSuccessBanner() {
        io.readString(
                "Order successfully edited.  Please hit enter to continue");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public String printYOrNEdit() {
        return io.readString("Would you like to EDIT another Mp3? y/n");
    }

    public void orderSummary(Flooring order) {
        System.out.println("Order #: " + order.getOrderNumber() + "\n" + " Order Date: "
                + order.getOrderDate() + "\n" + " Customer Name: " + order.getCustomerFirstName() + " " + order.getCustomerLastName() + "\n"
                + " State Abbr: " + order.getState()
                + " Tax Rate: " + order.getTaxRate() + "%" + "\n" + " Product Type: " + order.getProductType());
        System.out.println("Material Cost Per Square Foot: " + order.getCostPerSquareFoot());
        System.out.println("Labor Cost Per Sqaure Foot " + order.getLaborCostPerSquareFoot());
        System.out.println("Total Material Cost " + order.getMaterialCost());
        System.out.println("Total Labor Cost " + order.getLaborCost());
        System.out.println("Total Taxes " + order.getTax());
        System.out.println("Total Cost " + order.getTotal());
    }

}
