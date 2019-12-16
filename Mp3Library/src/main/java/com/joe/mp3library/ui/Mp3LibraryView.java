/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.ui;

import com.joe.mp3library.dto.Mp3;
import java.util.List;

/**
 *
 * @author joe
 */
public class Mp3LibraryView {

    private UserIO io;

    public Mp3LibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Mp3 Library");
        io.print("2. Add Mp3");
        io.print("3. Remove Mp3");
        io.print("4. Edit Mp3");
        io.print("5. Search Mp3");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Mp3 getNewMp3Info() {
        String title = io.readString("Please Enter Title Of Mp3: ");
        String artist = io.readString("Please Enter Artist Of Mp3: ");
        String album = io.readString("Please Enter Album Of Mp3: ");
        String year = io.readString("Please Enter Year Of Mp3: ");
        String genre = io.readString("Please Enter Genre Of Mp3: ");
        String notes = io.readString("Please Enter Any Extra Notes: ");
        Mp3 currentMp3 = new Mp3(title);
        currentMp3.setArtist(artist);
        currentMp3.setAlbum(album);
        currentMp3.setYear(year);
        currentMp3.setGenre(genre);
        currentMp3.setNotes(notes);
        return currentMp3;
    }

    public Mp3 editMp3Info() {
        io.print("Please Refer To Above When Editing Mp3 Info: ");
        String title = io.readString("Please Enter Updated Title Of Mp3: ");
        String artist = io.readString("Please Enter Updated Artist Of Mp3: ");
        String album = io.readString("Please Enter Updated Album Of Mp3: ");
        String year = io.readString("Please Enter Updated Year Of Mp3: ");
        String genre = io.readString("Please Enter Updated Genre Of Mp3: ");
        String notes = io.readString("Please Enter Updated Notes Of Mp3: ");
        Mp3 currentMp3 = new Mp3(title);
        currentMp3.setArtist(artist);
        currentMp3.setAlbum(album);
        currentMp3.setYear(year);
        currentMp3.setGenre(genre);
        currentMp3.setNotes(notes);
        return currentMp3;
    }

    public void displayCreateMp3Banner() {
        io.print("=== Create Mp3 ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Mp3 successfully created.");
    }

    public String printYOrNAdd() {
        return io.readString("Would you like to CREATE another Mp3? y/n");
    }

    public String printYOrNRemove() {
        return io.readString("Would you like to REMOVE another Mp3? y/n");
    }

    public String printYOrNEdit() {
        return io.readString("Would you like to EDIT another Mp3? y/n");
    }

    public void displayMp3List(List<Mp3> mp3List) {
        for (Mp3 currentMp3 : mp3List) {
            io.print("Title: " + currentMp3.getTitle() + "  ||  "
                    + "Artist: " + currentMp3.getArtist() + "  ||  "
                    + "Album: " + currentMp3.getAlbum() + "  ||  "
                    + "Year: " + currentMp3.getYear() + "  ||  "
                    + "Genre: " + currentMp3.getGenre() + "  ||  "
                    + "Notes: " + currentMp3.getYear());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Mp3s ===");
    }

    public void displayDisplayMp3Banner() {
        io.print("=== Display Mp3 ===");
    }

    public String getTitleChoice() {
        return io.readString("Please Enter The Title Of Mp3.");
    }

    public void displayMp3(Mp3 mp3) {
        if (mp3 != null) {
            io.print(mp3.getTitle());
            io.print("");
            io.print("Title: " + mp3.getTitle());
            io.print("Artist: " + mp3.getArtist());
            io.print("Album: " + mp3.getAlbum());
            io.print("Year: " + mp3.getYear());
            io.print("Genre: " + mp3.getGenre());
            io.print("Notes: " + mp3.getNotes());
            io.print("");
        } else {
            io.print("No Such Mp3.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayMp32(Mp3 mp3) {
        if (mp3 != null) {
            io.print(mp3.getTitle());
            io.print("");
            io.print("Title: " + mp3.getTitle());
            io.print("Artist: " + mp3.getArtist());
            io.print("Album: " + mp3.getAlbum());
            io.print("Year: " + mp3.getYear());
            io.print("Genre: " + mp3.getGenre());
            io.print("Notes: " + mp3.getNotes());
            io.print("");
        } else {
            io.print("No Such Mp3.");
        }
    }

    public void displayRemoveMp3Banner() {
        io.print("=== Remove Mp3 ===");
    }

    public void displayEditMp3Banner() {
        io.print("=== Edit Mp3 ===");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Mp3 successfully removed.");
    }

    public void displayEditSuccessBanner() {
        io.print("Mp3 successfully edited in library.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
