/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.Products;

/**
 *
 * @author joe
 */
public interface ProductsDao {
    
    Products getProduct(String productType) throws FlooringMasteryPersistenceException;
    
}
