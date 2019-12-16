/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook.ui;

import com.joe.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author joe
 */
public class AddressBookView {

    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List All Addresses");
        io.print("2. Create New Address");
        io.print("3. View An Address By Last Name");
        io.print("4. Remove An Address");
        io.print("5. View Count of Address Book");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String streetAddress = io.readString("Please enter Street Address");
        Address currentAddress = new Address(streetAddress);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        return currentAddress;
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getLastName() + ": "
                    + currentAddress.getFirstName() + " "
                    + currentAddress.getLastName() + ", "
                    + currentAddress.getStreetAddress());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayAddressListCount(List<Address> addressList) {

        io.print(addressList.size());

    }

    public String getLastNameChoice() {
        return io.readString("Please enter the Last Name for the Address.");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreetAddress());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayAddressCountBanner() {
        io.print("=== Address Book Count ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Address successfully created.  Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public void displayDisplayAddressBanner() {
        io.print("=== Display Address ===");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

}
