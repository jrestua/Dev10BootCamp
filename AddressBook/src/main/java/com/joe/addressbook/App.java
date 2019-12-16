/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.addressbook;

import com.joe.addressbook.controller.AddressBookController;
import com.joe.addressbook.dao.AddressBookDao;
import com.joe.addressbook.dao.AddressBookDaoFileImpl;
import com.joe.addressbook.ui.AddressBookView;
import com.joe.addressbook.ui.UserIO;
import com.joe.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author joe
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller
                = new AddressBookController(myDao, myView);
        controller.run();
    }

}
