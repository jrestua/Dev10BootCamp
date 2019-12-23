/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.ui;

import com.joe.mp3library.dto.Mp3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public String printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Mp3 Library");
        io.print("2. Add Mp3");
        io.print("3. Remove Mp3");
        io.print("4. Edit Mp3");
        io.print("5. Search Mp3");
        io.print("6. Exit");

        return io.readString("Please select from the above choices. 1 Through 6.");
    }

    public Mp3 getNewMp3Info() {
        String title = io.readString("Please Enter Title Of Mp3: ");
        String artist = io.readString("Please Enter Artist Of Mp3: ");
        String album = io.readString("Please Enter Album Of Mp3: ");
        String releaseDateString = io.readString("Please Enter Release Date Of Mp3 (MM/dd/yy): ");
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yy");
            LocalDate releaseDate= LocalDate.parse(releaseDateString,formatter);
        String genre = io.readString("Please Enter Genre Of Mp3: ");
        String notes = io.readString("Please Enter Any Extra Notes: ");
        Mp3 currentMp3 = new Mp3(title);
        if ((artist != "") || (album != "") || (releaseDate != null) || (genre != "") || (notes != "")) {
            currentMp3.setArtist(artist);
            currentMp3.setAlbum(album);
            currentMp3.setReleaseDate(releaseDate);
            currentMp3.setGenre(genre);
            currentMp3.setNotes(notes);
        }

        return currentMp3;
    }

    public boolean editMp3(Mp3 editMp3) {
        String userSelection = "";
        if (editMp3 != null) {
            io.print("Edit Menu");
            io.print("1. Title");
            io.print("2. Release Date");
            io.print("3. Album");
            io.print("4. Artist");
            io.print("5. Genre");
            io.print("6. User Rating/Note");

            userSelection = io.readString("Which field would you like to edit? 1 Through 6.");

            switch (userSelection) {
                case "1":
                    String title = io.readString("Please enter new Title");
                    editMp3.setTitle(title);
                    displayEditSuccessBanner();
                    break;
                case "2":
                    String releaseDateString = io.readString("Please enter new Release Date (MM/dd/yy)");
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yy");
                    LocalDate releaseDate= LocalDate.parse(releaseDateString,formatter);
                    editMp3.setReleaseDate(releaseDate);
                    displayEditSuccessBanner();
                    break;
                case "3":
                    String album = io.readString("Please enter new Album");
                    editMp3.setAlbum(album);
                    displayEditSuccessBanner();
                    break;
                case "4":
                    String artist = io.readString("Please enter new Artist");
                    editMp3.setArtist(artist);
                    displayEditSuccessBanner();
                    break;
                case "5":
                    String genre = io.readString("Please enter new Genre");
                    editMp3.setGenre(genre);
                    displayEditSuccessBanner();
                    break;
                case "6":
                    String notes = io.readString("Please enter new Rating/Note");
                    editMp3.setNotes(notes);
                    displayEditSuccessBanner();
                    break;
                default:
                    displayUnknownCommandBanner();
            }
        } else {
            io.print("MP3 not in library");
            return false;
        }
        return true;
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
                    + "Release Date: " + currentMp3.getReleaseDate() + "  ||  "
                    + "Genre: " + currentMp3.getGenre() + "  ||  "
                    + "Notes: " + currentMp3.getNotes());
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
            io.printLocalDate(("Release Date: "), mp3.getReleaseDate());
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
            io.printLocalDate(("Release Date: "), mp3.getReleaseDate());
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
