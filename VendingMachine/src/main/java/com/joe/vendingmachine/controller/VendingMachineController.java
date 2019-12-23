/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.controller;

import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachineDaoException;
import com.joe.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.joe.vendingmachine.dto.Inventory;
import com.joe.vendingmachine.ui.UserIO;
import com.joe.vendingmachine.ui.UserIOConsoleImpl;
import com.joe.vendingmachine.ui.VendingMachineView;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineController {

    DecimalFormat df = new DecimalFormat("0.00");

    private UserIO io = new UserIOConsoleImpl();
    VendingMachineView view;
    VendingMachineDao dao;
    VendingMachineDaoFileImpl daoFI;

    public VendingMachineController(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws VendingMachineDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            listInventories();
            io.print("1. Gummy Bears");
            io.print("2. Soda");
            io.print("3. Water");
            io.print("4. Chips");
            io.print("5. Pudding");
            io.print("6. Exit");

            io.print("");
            io.print("Total Amount Inserted = ");
            double addChangeAmount = addChange();
            io.print(df.format(addChange()));

            menuSelection = io.readInt("Please select from the above choices. (1-6)", 1, 6);
            
            String vendingMachineItem = "";
            
            if (menuSelection == 1){
                vendingMachineItem = "Gummy Bears";
            }
            if (menuSelection == 2){
                vendingMachineItem = "Soda";
            }
            if (menuSelection == 3){
                vendingMachineItem = "Water";
            }
            if (menuSelection == 4){
                vendingMachineItem = "Chips";
            }
            if (menuSelection == 5){
                vendingMachineItem = "Pudding";
            }


            Inventory inventory = dao.getInventory(vendingMachineItem);

            switch (menuSelection) {

                case 1:
                    
                    if (addChangeAmount >= view.comparePrice(inventory)) {
                        int stock = view.subtractStock(inventory);
                        int newStock = stock-=1;
                        inventory.setInStock(newStock);
                    }
                    break;
                case 2:
                    if (addChangeAmount >= view.comparePrice(inventory)) {
                        System.out.println("It works");
                    }
                    break;
                case 3:
                    if (addChangeAmount >= view.comparePrice(inventory)) {
                        System.out.println("It works");
                    }
                    break;
                case 4:
                    if (addChangeAmount >= view.comparePrice(inventory)) {
                        System.out.println("It works");
                    }
                    break;
                case 5:
                    if (addChangeAmount >= view.comparePrice(inventory)) {
                        System.out.println("It works");
                    }
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    public void listInventories() {
        view.displayDisplayAllBanner();
        List<Inventory> inventoryList = dao.getAllInventory();
        view.displayInventoryList(inventoryList);
        view.selectionDisplayBanner();
    }


    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private String getYOrNAddChange() {
        return view.printYOrNAddChange();
    }

    private double addChange() {
        String keepAdding = "y";
        Double money = 0.00;
        do {
            String coin = io.readString("Insert Coin (penny/nickel/dime/quarter): ");
            if (coin.equals("penny")) {
                money += .01;
                keepAdding = getYOrNAddChange();
            }
            if (coin.equals("nickel")) {
                money += .05;
                keepAdding = getYOrNAddChange();
            }
            if (coin.equals("dime")) {
                money += .10;
                keepAdding = getYOrNAddChange();
            }
            if (coin.equals("quarter")) {
                money += .25;
                keepAdding = getYOrNAddChange();
            }
        } while (keepAdding.equals("y"));
        return money;
    }

    private void viewInventory() {
        String name = view.getInventoryChoice();
        Inventory inventory = dao.getInventory(name);
        view.displayInventory(inventory);
    }
    
        private void updateInventory(Inventory updatedInventory) {
    
        do {
            Inventory newStockInventory = view.getNewMp3Info();
            dao.removeInventory(updatedInventory.setInStock(newStock), updatedInventory);
        } while (keepAdding.equals("y"));
    }
       

}
