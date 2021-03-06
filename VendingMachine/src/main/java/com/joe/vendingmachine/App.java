/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.vendingmachine;

import com.joe.vendingmachine.controller.VendingMachineController;
import com.joe.vendingmachine.dao.VendingMachineAuditDao;
import com.joe.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.joe.vendingmachine.dao.VendingMachineDao;
import com.joe.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.joe.vendingmachine.service.VendingMachineServiceLayer;
import com.joe.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.joe.vendingmachine.ui.UserIO;
import com.joe.vendingmachine.ui.UserIOConsoleImpl;
import com.joe.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author joe
 */
//Runs everything from here.
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();
    }
}
