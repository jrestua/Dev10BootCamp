/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook.dao;

import com.joe.addressbook.dto.Address;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joe
 */
public class AddressBookDaoTest {
    
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        List<Address>addressList = dao.getAllAddresses();
        for (Address address: addressList) {
            dao.removeAddress(address.getStreetAddress());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddGetAddress() throws Exception {
        Address address = new Address("16 Molly Pticher Drive");
        address.setFirstName("Joe");
        address.setLastName("Restua");
        
        dao.addAddress(address.getStreetAddress(), address);
        
        Address fromDao = dao.getAddress(address.getStreetAddress());
        
        assertEquals(address, fromDao);
        
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        Address address1 = new Address("24 Bryant Street");
        address1.setFirstName("Mike");
        address1.setLastName("Jones");
        
        dao.addAddress(address1.getStreetAddress(), address1);
        
        Address address2 = new Address("23 Jordan Ave");
        address2.setFirstName("LeBron");
        address2.setLastName("James");
        
        dao.addAddress(address2.getStreetAddress(), address2);
        
        assertEquals(3, dao.getAllAddresses().size());
    }


    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() throws Exception {
         Address address1 = new Address("24 Bryant Street");
        address1.setFirstName("Mike");
        address1.setLastName("Jones");
        
        dao.addAddress(address1.getStreetAddress(), address1);
        
        Address address2 = new Address("23 Jordan Ave");
        address2.setFirstName("LeBron");
        address2.setLastName("James");
        
        dao.addAddress(address2.getStreetAddress(), address2);
        
        dao.removeAddress(address1.getStreetAddress());
        assertEquals(2, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address1.getStreetAddress()));
        
        dao.removeAddress(address2.getStreetAddress());
        assertEquals(1, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address2.getStreetAddress()));
    }
    
}
