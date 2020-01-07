/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.dao;

import com.joe.flooringmastery.dto.StateTax;
import java.util.List;

/**
 *
 * @author joe
 */
public interface StateTaxDao {
    
    List<StateTax> getAllTaxes() throws FlooringMasteryPersistenceException;
    
    StateTax getStateName(String state) throws FlooringMasteryPersistenceException;
    
}
