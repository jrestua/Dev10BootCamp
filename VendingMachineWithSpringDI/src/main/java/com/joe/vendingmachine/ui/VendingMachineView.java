/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.ui;

import com.joe.vendingmachine.dto.CoinsEnum;
import com.joe.vendingmachine.dto.Inventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author joe
 */
public class VendingMachineView {
    
    //Dependency injection
    private UserIO io;
    CoinsEnum coinValues;

    //Constructor for dependency injection
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    
    //Prints first menu.
    public int printMenuAndGetSelection() {
        io.print("");
        io.print("Vending Machine");
        io.print("1. Enter Vending Machine");
        io.print("2. Leave Program");
        try{
        return io.readInt("Please select from the above choices (1 or 2).", 1, 2);
        }
        catch (NumberFormatException e){
        io.print("Invalid Input");
        return 0;
        }
    }

    public BigDecimal askUserMoney(List<Inventory> itemList) {
        io.print("Inventory:");
        itemList.forEach((i) -> {
            if (i.getInStock() >= 0) {
                io.print("(" + (itemList.indexOf(i) + 1) + ") " + ("Item: ") + i.getName()
                        + " $" + i.getPrice() + " Amount In Stock: " + i.getInStock());
            }
        });
        
        //Ask user for change to insert in machine.
        BigDecimal userMoney = null;
        do {
            DecimalFormat df = new DecimalFormat("0.00");
            String keepAdding = "y";
            double amountTotal = 0.00;
            do {
                String input = io.readString("Please Insert A Coin (quarter/dime/nickel/penny): ");
                if (input.equals("quarter")) {
                    amountTotal += .25;
                }
                if (input.equals("dime")) {
                    amountTotal += .10;
                }
                if (input.equals("nickel")) {
                    amountTotal += .05;
                }
                if (input.equals("penny")) {
                    amountTotal += .01;
                }
                keepAdding = printYOrNAddChange();
                if (keepAdding.equals("y")) {
                    io.print("Your Total Amount Inserted: " + df.format(amountTotal));
                }
                if (keepAdding.equals("n")) {
                    io.print("Your Total Amount Inserted: " + df.format(amountTotal));
                }
                userMoney = new BigDecimal(amountTotal);
            } while (keepAdding.equals("y"));

            itemList.forEach((i) -> {
                if (i.getInStock() >= 0) {
                    io.print("(" + (itemList.indexOf(i) + 1) + ") " + i.getName() + " $" + i.getPrice() + " Amount In Stock: " + i.getInStock());
                }
            });

        } while (userMoney == null);
        userMoney = userMoney.setScale(2, RoundingMode.HALF_UP);
        return userMoney;
    }

    //Subtracts item from inventory
    public Inventory purchaseItem(List<Inventory> itemList) {
        int userPick = io.readInt("Please select an item.", 1, itemList.size());
        return itemList.get(userPick - 1);
    }
    
    //Returns change
    public void returnChange(BigDecimal userMoney, BigDecimal itemCost) {
        int quarters = 0, dimes = 0, nickels = 0, pennies = 0;
        BigDecimal change = userMoney.subtract(itemCost);
        while (change.compareTo(BigDecimal.ZERO) > 0) {
            if (change.compareTo(CoinsEnum.QUARTER.getValue()) >= 0) {
                quarters++;
                change = change.subtract(CoinsEnum.QUARTER.getValue());
            } else if (change.compareTo(CoinsEnum.DIME.getValue()) >= 0) {
                dimes++;
                change = change.subtract(CoinsEnum.DIME.getValue());
            } else if (change.compareTo(CoinsEnum.NICKEL.getValue()) >= 0) {
                nickels++;
                change = change.subtract(CoinsEnum.NICKEL.getValue());
            } else {
                pennies++;
                change = change.subtract(CoinsEnum.PENNY.getValue());
            }
        }

        io.print("Returning your change: ");
        io.print(quarters + " - Quarter(s)");
        io.print(dimes + " - Dime(s)");
        io.print(nickels + " - Nickel(s)");
        io.print(pennies + " - Penny(s)");
    }

    public void displayVendingMachineBanner() {
        io.print("*** Are You Hungry? ***");
    }

    public String printYOrNAddChange() {
        return io.readString("Would you like to keep adding coins? y/n");
    }

    public void displayExitBanner() {
        io.print("Thank you. Come again");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
