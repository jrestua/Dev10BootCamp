/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine;

import com.joe.vendingmachine.controller.VendingMachineController;
import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachineDaoException;
import com.joe.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.joe.vendingmachine.ui.UserIO;
import com.joe.vendingmachine.ui.UserIOConsoleImpl;
import com.joe.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author joe
 */
public class App {

public static void main(String[] args) throws VendingMachineDaoException {
    UserIO myIo = new UserIOConsoleImpl();
    VendingMachineView myView = new VendingMachineView(myIo);
    VendingMachineDao myDao = new VendingMachineDaoFileImpl();
    VendingMachineController controller = 
            new VendingMachineController(myDao, myView);
    controller.run();
}
}
