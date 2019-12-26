/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.controller;

import com.joe.vendingmachine.dao.VendingMachinePersistenceException;
import com.joe.vendingmachine.dto.Inventory;
import com.joe.vendingmachine.service.InsufficientFundsException;
import com.joe.vendingmachine.service.SoldOutInventoryException;
import com.joe.vendingmachine.service.VendingMachineServiceLayer;
import com.joe.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineController {

    //Dependency Injection
    VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    //Called on in app, order in which things are ran
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        vendingMachineMenu();
                        break;
                    case 2:
                        keepGoing = false;
                        break;
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    //Prints out Menu from view file. Gives user option to enter vending machine or quite.
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //Once entered in vending machine, follows this method to display whats inside, add change into
    //machine, displays money entered, ask user what they want, vends product, and returns change.
    //If not enough money, throws error.
    private void vendingMachineMenu() throws VendingMachinePersistenceException {
        List<Inventory> itemList = service.getAllItems();
        view.displayVendingMachineBanner();
        boolean hasErrors = false;
        do {
            BigDecimal userMoney = view.askUserMoney(itemList);
            Inventory soldItem = view.purchaseItem(itemList);
            System.out.println("Purchasing: " + soldItem.getName());
            BigDecimal itemCost = soldItem.getPrice();
            System.out.println("Cost: " + itemCost);
            try {
                service.buyItem(itemList.indexOf(soldItem), userMoney);

                view.returnChange(userMoney, itemCost);
                hasErrors = false;
            } catch (InsufficientFundsException | SoldOutInventoryException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
