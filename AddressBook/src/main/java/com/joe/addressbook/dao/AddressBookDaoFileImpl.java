/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook.dao;

import com.joe.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author joe
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String streetAddress, Address address) {
        Address newAddress = addresses.put(streetAddress, address);
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) {
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) {
        Address removedAddress = addresses.remove(lastName);
        return removedAddress;
    }

}
