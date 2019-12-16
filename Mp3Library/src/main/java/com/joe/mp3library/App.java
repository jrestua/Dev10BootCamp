/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library;

import com.joe.mp3library.controller.Mp3LibraryController;
import com.joe.mp3library.dao.Mp3LibraryDao;
import com.joe.mp3library.dao.Mp3LibraryDaoFileImpl;
import com.joe.mp3library.ui.Mp3LibraryView;
import com.joe.mp3library.ui.UserIO;
import com.joe.mp3library.ui.UserIOConsoleImpl;

/**
 *
 * @author joe
 */
public class App {
    //How the program starts
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        Mp3LibraryView myView = new Mp3LibraryView(myIo);
        Mp3LibraryDao myDao = new Mp3LibraryDaoFileImpl();
        Mp3LibraryController controller
                = new Mp3LibraryController(myDao, myView);
        controller.run();
    }
}
