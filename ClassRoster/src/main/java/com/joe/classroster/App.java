/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.classroster;

import com.joe.classroster.controller.ClassRosterController;
import com.joe.classroster.dao.ClassRosterAuditDao;
import com.joe.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.joe.classroster.dao.ClassRosterDao;
import com.joe.classroster.dao.ClassRosterDaoFileImpl;
import com.joe.classroster.service.ClassRosterServiceLayer;
import com.joe.classroster.service.ClassRosterServiceLayerImpl;
import com.joe.classroster.ui.ClassRosterView;
import com.joe.classroster.ui.UserIO;
import com.joe.classroster.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author joe
 */
public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        //UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        //ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        //ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // Instantiate the Audit DAO
        //ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        //ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        //ClassRosterController controller = new ClassRosterController(myService, myView);
        // Kick off the Controller
        //controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = 
           ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
