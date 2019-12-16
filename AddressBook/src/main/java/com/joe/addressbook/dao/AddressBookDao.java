/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook.dao;

import com.joe.addressbook.dto.Address;
import java.util.List;


/**
 *
 * @author joe
 */
public interface AddressBookDao {
    
    Address addAddress(String streetAddress, Address address);
    
    List<Address> getAllAddresses();
    
    Address getAddress(String lastName);
    
    Address removeAddress(String lastName);

}