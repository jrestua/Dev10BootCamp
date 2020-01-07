/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery;

import com.joe.flooringmastery.controller.FlooringMasteryController;
import com.joe.flooringmastery.dao.FlooringMasteryAuditDao;
import com.joe.flooringmastery.dao.FlooringMasteryAuditDaoFileImpl;
import com.joe.flooringmastery.dao.FlooringMasteryDao;
import com.joe.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.joe.flooringmastery.dao.ProductsDao;
import com.joe.flooringmastery.dao.ProductsDaoFileImpl;
import com.joe.flooringmastery.dao.StateTaxDao;
import com.joe.flooringmastery.dao.StateTaxDaoFileImpl;
import com.joe.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.joe.flooringmastery.service.FlooringMasteryOrderValidationException;
import com.joe.flooringmastery.service.FlooringMasteryProductValidationException;
import com.joe.flooringmastery.service.FlooringMasteryServiceLayer;
import com.joe.flooringmastery.service.FlooringMasteryServiceLayerImpl;
import com.joe.flooringmastery.service.FlooringMasteryStateValidationException;
import com.joe.flooringmastery.ui.FlooringMasteryView;
import com.joe.flooringmastery.ui.UserIO;
import com.joe.flooringmastery.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author joe
 */
public class App {

    public static void main(String[] args) throws FlooringMasteryDuplicateIdException, FlooringMasteryStateValidationException, FlooringMasteryOrderValidationException, FlooringMasteryProductValidationException {       
        /*
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        FlooringMasteryView myView = new FlooringMasteryView(myIo);
        // Instantiate the DAO
        FlooringMasteryDao myDao = new FlooringMasteryDaoFileImpl();
        StateTaxDao stateTaxDao = new StateTaxDaoFileImpl();
        ProductsDao productsDao = new ProductsDaoFileImpl();
        // Instantiate the Audit DAO
        FlooringMasteryAuditDao myAuditDao = new FlooringMasteryAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        FlooringMasteryServiceLayer myService = new FlooringMasteryServiceLayerImpl(myDao, stateTaxDao, productsDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        FlooringMasteryController controller = new FlooringMasteryController(myService, myView);
        // Kick off the Controller
        controller.run();
*/
        
        
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringMasteryController controller
                = ctx.getBean("controller", FlooringMasteryController.class);
        controller.run();

    }
}
