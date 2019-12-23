/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine.dao;

import com.joe.vendingmachine.dto.Inventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joe
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Inventory> inventories = new HashMap<>();

    public static final String STOCK_FILE = "stock.txt";
    public static final String DELIMITER = "::";

    @Override
    public List<Inventory> getAllInventory() {
        try {
            loadInventory();
        } catch (VendingMachineDaoException ex) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList(inventories.values());
    }
    
    @Override
public Inventory getInventory(String name) {
    return inventories.get(name);
}

    @Override
    public Inventory editInventory(String name, Inventory inventory) {
        Inventory editedInventory = inventories.replace(name, inventory);
        return editedInventory;
    }
    
    

    private Inventory unmarshallInventory(String inventoryAsText) {
        String[] inventoryTokens = inventoryAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String name = inventoryTokens[0];

        Inventory inventoryFromFile = new Inventory(name);

        // Index 1 - cost
        inventoryFromFile.setCost(Double.parseDouble(inventoryTokens[1]));

        // Index 2 - inStock
        inventoryFromFile.setInStock(Integer.parseInt(inventoryTokens[2]));

        // We have now created a student! Return i
        return inventoryFromFile;
    }

    private void loadInventory() throws VendingMachineDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(STOCK_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Inventory currentInventory;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentInventory = unmarshallInventory(currentLine);

            inventories.put(currentInventory.getName(), currentInventory);
        }
        scanner.close();
    }

    private String marshallInventory(Inventory aInventory) {

        String inventoryAsText = aInventory.getName() + DELIMITER;

        inventoryAsText += aInventory.getCost() + DELIMITER;

        inventoryAsText += aInventory.getInStock() + DELIMITER;

        return inventoryAsText;
    }


    private void writeInventory() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(STOCK_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException(
                    "Could not save student data.", e);
        }

        String inventoryAsText;
        List<Inventory> inventoryList = this.getAllInventory();
        for (Inventory currentInventory : inventoryList) {
            inventoryAsText = marshallInventory(currentInventory);
            out.println(inventoryAsText);
            out.flush();
        }
        out.close();
    }

}
