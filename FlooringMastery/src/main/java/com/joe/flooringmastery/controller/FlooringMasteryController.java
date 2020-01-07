/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.controller;

import com.joe.flooringmastery.dao.FlooringMasteryDao;
import com.joe.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.joe.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.joe.flooringmastery.dto.Flooring;
import com.joe.flooringmastery.service.FlooringMasteryDataValidationException;
import com.joe.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.joe.flooringmastery.service.FlooringMasteryInvalidOrderNumberException;
import com.joe.flooringmastery.service.FlooringMasteryOrderValidationException;
import com.joe.flooringmastery.service.FlooringMasteryProductValidationException;
import com.joe.flooringmastery.service.FlooringMasteryServiceLayer;
import com.joe.flooringmastery.service.FlooringMasteryStateValidationException;
import com.joe.flooringmastery.ui.FlooringMasteryView;
import com.joe.flooringmastery.ui.UserIO;
import com.joe.flooringmastery.ui.UserIOConsoleImpl;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author joe
 */
public class FlooringMasteryController {

    private UserIO io = new UserIOConsoleImpl();

    FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;
    private FlooringMasteryDao dao;

    public FlooringMasteryController(FlooringMasteryServiceLayer service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws FlooringMasteryDuplicateIdException, FlooringMasteryStateValidationException, FlooringMasteryOrderValidationException, FlooringMasteryProductValidationException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                     view.resetModeReadWrite();
                    view.trainingModeReadWrite();
                    view.displayTrainingModeBanner();
                    flooringMasteryMenu();
                    break;
                case 2:
                     view.resetModeReadWrite();
                    view.productionModeReadWrite();
                    view.displayProductionModeBanner();
                    flooringMasteryMenu();
                    break;
                case 3:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    //Prints out Menu from view file. Gives user option to enter training or production mode.
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private int getMenuSelectionSecondMenu() {
        return view.printMenuAndGetSelectionSecondMenu();
    }

    private void flooringMasteryMenu() throws FlooringMasteryDuplicateIdException, FlooringMasteryStateValidationException, FlooringMasteryOrderValidationException, FlooringMasteryProductValidationException {
        boolean secondKeepGoing = true;
        int secondMenuSelection = 0;
        try {
            while (secondKeepGoing) {
                secondMenuSelection = getMenuSelectionSecondMenu();

                switch (secondMenuSelection) {
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        int orderNumberMax = getMaxOrderNumberList();
                        createOrder(orderNumberMax);
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        getOrder();
                        break;
                    case 6:
                        secondKeepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (FlooringMasteryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createOrder(int orderNumberMax) throws FlooringMasteryPersistenceException, FlooringMasteryDuplicateIdException, FlooringMasteryOrderValidationException, FlooringMasteryStateValidationException, FlooringMasteryProductValidationException {
        view.displayNewOrderBanner();
        boolean hasErrors = false;
        do {
             Flooring currentOrder = view.getNewOrderInfo(orderNumberMax);
            try {
                service.createOrder(currentOrder);
                service.calculateOrder(currentOrder);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (FlooringMasteryDuplicateIdException | FlooringMasteryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    private void listOrders() throws FlooringMasteryPersistenceException {
        List<Flooring> orderList = service.getAllOrders();

        view.displayOrderList(orderList);
    }

    private int getMaxOrderNumberList() throws FlooringMasteryPersistenceException{
        List<Flooring> orderList = service.getAllOrders();
        if (orderList.size() != 0){
        return view.getMaxOrderNumber(orderList);
        }
        else{
            return 0;
        }
    }

    public void getOrder() throws FlooringMasteryPersistenceException {

        view.displayDisplayAllBanner();
        LocalDate date = view.getOrderDateChoice();
        List<Flooring> orders = service.getOrder(date);
        view.displayOrder(orders);

    }

    private void removeOrder() throws FlooringMasteryPersistenceException {
        view.displayRemoveOrderBanner();
        String orderNumber = view.getOrderNumberChoice();
        service.removeOrder(orderNumber);
        view.displayRemoveSuccessBanner();
    }

    private void editOrder() throws FlooringMasteryPersistenceException {

        try {
            String orderNumber = view.getOrderNumberChoice();
            Flooring savedOrder = service.getOrder2(orderNumber);
            Flooring editedOrder = view.editOrder(savedOrder);
            Flooring updatedOrder = service.compareOrders(savedOrder, editedOrder);
            view.displayEditOrderBanner();
            view.orderSummary(updatedOrder);
            String response = view.askSave();
            if (response.equalsIgnoreCase("Y")) {
                service.editOrder(updatedOrder);
                view.displayEditSuccessBanner();
            } else if (response.equalsIgnoreCase("N")) {
                view.displayEditSuccessBanner();
            } else {
                unknownCommand();
            }
        } catch (FlooringMasteryInvalidOrderNumberException
                | FlooringMasteryProductValidationException | FlooringMasteryStateValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private String getYOrNEdit() {
        return view.printYOrNEdit();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
