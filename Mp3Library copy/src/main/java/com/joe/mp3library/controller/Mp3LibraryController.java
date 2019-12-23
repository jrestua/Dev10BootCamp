/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.controller;

import com.joe.mp3library.dao.Mp3LibraryDao;
import com.joe.mp3library.dao.Mp3LibraryDaoException;
import com.joe.mp3library.dao.Mp3LibraryDaoFileImpl;
import com.joe.mp3library.dto.Mp3;
import com.joe.mp3library.ui.Mp3LibraryView;
import com.joe.mp3library.ui.UserIO;
import com.joe.mp3library.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author joe
 */
public class Mp3LibraryController {

    Mp3LibraryView view;
    Mp3LibraryDao dao;

    public Mp3LibraryController(Mp3LibraryDao dao, Mp3LibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    private UserIO io = new UserIOConsoleImpl(); //Remove once edit feature is complete
    //Main method that runs everything.Gets called in App class

    public void run() {
        boolean keepGoing = true;
        String menuSelection = "";
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case "1":
                        listMp3s();
                        break;
                    case "2":
                        createMp3();
                        break;
                    case "3":
                        removeMp3();
                        break;
                    case "4":
                        editMp3();
                        break;
                    case "5":
                        viewMp3();
                        break;
                    case "6":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (Mp3LibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private String getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private String getYOrNAdd() {
        return view.printYOrNAdd();
    }

    private String getYOrNRemove() {
        return view.printYOrNRemove();
    }

    private String getYOrNEdit() {
        return view.printYOrNEdit();
    }

    private void createMp3() throws Mp3LibraryDaoException {
        String keepAdding = "y";
        do {
            view.displayCreateMp3Banner();
            Mp3 newMp3 = view.getNewMp3Info();
            dao.addMp3(newMp3.getTitle(), newMp3);
            view.displayCreateSuccessBanner();
            keepAdding = getYOrNAdd();
        } while (keepAdding.equals("y"));
    }

    private void listMp3s() throws Mp3LibraryDaoException {
        view.displayDisplayAllBanner();
        List<Mp3> mp3List = dao.getAllMp3s();
        view.displayMp3List(mp3List);
    }

    private void viewMp3() throws Mp3LibraryDaoException {
        view.displayDisplayMp3Banner();
        String title = view.getTitleChoice();
        Mp3 mp3 = dao.getMp3(title);
        view.displayMp3(mp3);
    }

    private void removeMp3() throws Mp3LibraryDaoException {
        String keepDeleting = "y";
        do {
            view.displayRemoveMp3Banner();
            String title = view.getTitleChoice();
            dao.removeMp3(title);
            view.displayRemoveSuccessBanner();
            keepDeleting = getYOrNRemove();
        } while (keepDeleting.equals("y"));
    }

    private void editMp3() throws Mp3LibraryDaoException {
        String keepEditing = "y";
        do {
            view.displayEditMp3Banner();
            String title = view.getTitleChoice();
            Mp3 editMp3 = dao.getMp3(title);
            if (view.editMp3(editMp3) == true) {
                dao.removeMp3(title);
                dao.addMp3(editMp3.getTitle(), editMp3);
                keepEditing = getYOrNEdit();
            } else {
                keepEditing = getYOrNEdit();
            }
        } while (keepEditing.equals("y"));
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
