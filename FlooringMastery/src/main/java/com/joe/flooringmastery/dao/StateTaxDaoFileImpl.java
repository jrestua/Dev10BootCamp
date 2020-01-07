/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import static com.joe.flooringmastery.dao.ProductsDaoFileImpl.DELIMITER;
import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.StateTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
public class StateTaxDaoFileImpl  implements StateTaxDao {
    
    private Map<String, StateTax> taxes = new HashMap<>();
    
    public static final String TAXES_FILE = "Taxes.txt";
    public static final String DELIMITER = "::";
    

    
/*
        @Override
    public List<Flooring> getTaxes(String state) throws FlooringMasteryPersistenceException {
        loadTaxes();
        return taxes.values()
                .stream()
                .filter(s -> s.getOrderDate().equals(state))
                .collect(Collectors.toList());

    }
*/
    
    
    public List<StateTax> getAllTaxes() throws FlooringMasteryPersistenceException {
        loadTaxes();
        return new ArrayList<>(taxes.values());
    }
    
    public StateTax getStateName(String state) throws FlooringMasteryPersistenceException {
        loadTaxes();
        StateTax taxRate = taxes.get(state);
            return taxRate;
    }    
    
    /*
    private StateTax unmarshallTax(String taxAsText) {

        String[] taxTokens = taxAsText.split(DELIMITER);

        StateTax taxFromFile = new StateTax(state);
        
        String state = taxTokens[0];   

        taxFromFile.setTaxRate(new BigDecimal(taxTokens[1]));    

        return taxFromFile;
    }
    */
    
   /* 
    public void loadTaxes() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load order data into memory.", e);
        }
        String currentLine;

        StateTax currentState;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentState = unmarshallTax(currentLine);

            taxes.put(currentState.getState(), currentState);
        }

        scanner.close();
    }
*/
    
    private void loadTaxes() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXES_FILE)));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load states data into memory.", e);
        }
        String currentLine;
        while (scanner.hasNextLine()) {
            String[] currentTokens;
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
                StateTax currentState = new StateTax();
                currentState.setState(currentTokens[0]);
                currentState.setTaxRate(new BigDecimal(currentTokens[1]));
                taxes.put(currentState.getState(), currentState);
        }
        scanner.close();
    }
    
    
    
}
