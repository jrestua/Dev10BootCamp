/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook.controller;

import com.joe.addressbook.dao.AddressBookDao;
import com.joe.addressbook.dao.AddressBookDaoFileImpl;
import com.joe.addressbook.dto.Address;
import com.joe.addressbook.ui.AddressBookView;
import com.joe.addressbook.ui.UserIO;
import com.joe.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author joe
 */
public class AddressBookController {

    AddressBookView view;
    AddressBookDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listAddresses();
                    break;
                case 2:
                    createAddress();
                    break;
                case 3:
                    viewAddress();
                    break;
                case 4:
                    removeAddress();
                    break;
                case 5:
                    addressCount();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }
    
        private void addressCount() {
        view.displayAddressCountBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressListCount(addressList);
    }
    

    private void viewAddress() {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
