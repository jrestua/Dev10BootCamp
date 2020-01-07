/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.dto.Products;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class ProductsDaoFileImpl implements ProductsDao {

    private Map<String, Products> products = new HashMap<>();

    public static final String PRODUCTS_FILE = "Products.txt";
    public static final String DELIMITER = "::";

    /*
        @Override
    public List<Flooring> getProducts(String productType) throws FlooringMasteryPersistenceException {
        loadProducts();
  return products.values()
                .stream()
                .filter(s -> s.getOrderDate().equals(productType))
                .collect(Collectors.toList());
    }
     */
    
    public Products getProduct(String productType) throws FlooringMasteryPersistenceException {
        loadProducts();
       
            Products chosenProduct = products.get(productType);
                    
            return chosenProduct;
        
    }
    
    
 /*
    private Products unmarshallProduct(String productAsText) {

        String[] productTokens = productAsText.split(DELIMITER);

        String productType = productTokens[0];

        Products productFromFile = new Products(productType);

        productFromFile.setCostPerSquareFoot(new BigDecimal(productTokens[1]));

        productFromFile.setLaborCostPerSquareFoot(new BigDecimal(productTokens[2]));   

        return productFromFile;
    }
     
    
    
    public void loadProducts() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load order data into memory.", e);
        }
        String currentLine;

        Products currentProduct;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentProduct = unmarshallProduct(currentLine);

            products.put(currentProduct.getProductType(), currentProduct);
        }

        scanner.close();
    }
    */
    
        private void loadProducts() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTS_FILE)));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load states data into memory.", e);
        }
        String currentLine;
        while (scanner.hasNextLine()) {
            String[] currentTokens;
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
                Products currentProduct = new Products();
                currentProduct.setProductType(currentTokens[0]);
                currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
                currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));
                products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
}
