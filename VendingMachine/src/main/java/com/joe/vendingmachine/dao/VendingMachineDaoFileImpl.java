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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, Inventory> itemsMap = new HashMap<>();

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMETER = "::";

    private Inventory unmarshallItem(String itemAsText) {
        String[] itemTokens = itemAsText.split(DELIMETER);
        String name = itemTokens[0];
        BigDecimal price = new BigDecimal(itemTokens[1]);

        Inventory itemFromFile = new Inventory(name, price);

        itemFromFile.setInStock(Integer.parseInt(itemTokens[2]));

        return itemFromFile;
    }

    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Inventory currentItem;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);

            itemsMap.put(currentItem.getName(), currentItem);
        }
        scanner.close();
    }

    private String marshallItem(Inventory anItem) {
        //item name
        String itemAsText = anItem.getName() + DELIMETER;
        //item price
        itemAsText += anItem.getPrice() + DELIMETER;
        //item count
        itemAsText += anItem.getInStock();
        //return item
        return itemAsText;
    }

    private void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Inventory data could not be saved.", e);
        }

        String itemAsText;
        List<Inventory> itemList = this.getAllItemsInInventory();
        for (Inventory currentItem : itemList) {
            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public List<Inventory> getAllItemsInInventory() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<Inventory>(itemsMap.values());
    }

    @Override
    public Inventory updateItemQuantity(String name, Inventory newItem) throws VendingMachinePersistenceException {
        loadInventory();
        Inventory updatedItem = itemsMap.put(name, newItem);
        writeInventory();
        return updatedItem;
    }

    @Override
    public Inventory removeItem(String name) throws VendingMachinePersistenceException {
        loadInventory();
        Inventory removedItem = itemsMap.remove(name);
        writeInventory();
        return removedItem;
    }
}
