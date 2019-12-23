/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.ui;

import com.joe.vendingmachine.controller.VendingMachineController;
import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.joe.vendingmachine.dto.Inventory;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineView {

    DecimalFormat df = new DecimalFormat("0.00");

    private UserIO io;
    VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        displayDisplayAllBanner();
        List<Inventory> inventoryList = dao.getAllInventory();
        displayInventoryList(inventoryList);
        io.print("1. Gummy Bears");
        io.print("2. Soda");
        io.print("3. Water");
        io.print("4. Chips");
        io.print("5. Pudding");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices. (1-6)", 1, 6);
    }

    public void displayInventoryList(List<Inventory> inventoryList) {
        for (Inventory currentInventory : inventoryList) {
            io.print("Item: " + currentInventory.getName() + " - "
                    + "Price: " + "$" + df.format(currentInventory.getCost()) + " - "
                    + "Amount in Stock: " + currentInventory.getInStock());
        }
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display Vending Machine Stock ===");
    }

    public void selectionDisplayBanner() {
        io.print("");
        io.print("=== Please Select Item ===");
    }

    public String getInventoryChoice() {
        return io.readString("Please enter what item you would like?");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public String printYOrNAddChange() {
        return io.readString("Would you like to keep adding coins? y/n");
    }

    public String getItemChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayInventory(Inventory inventory) {
        if (inventory != null) {
            io.print(inventory.getName());
            io.printDouble(inventory.getCost());
            io.printInt(inventory.getInStock());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public double comparePrice(Inventory inventory) {
        double cost = 0.00;
        if (inventory != null) {
            cost = inventory.getCost();
    }
        return cost;
}
    
        public int subtractStock(Inventory inventory) {
        int stockAmount = 0;
        if (inventory != null) {
            stockAmount = inventory.getInStock();
    }
        return stockAmount;
}
        
          

            
    
}
