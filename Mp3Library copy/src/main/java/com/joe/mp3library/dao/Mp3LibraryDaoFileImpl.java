/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.dao;

import com.joe.mp3library.dto.Mp3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class Mp3LibraryDaoFileImpl implements Mp3LibraryDao {

    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    private Map<String, Mp3> mp3s = new HashMap<>();

    @Override
    public Mp3 addMp3(String title, Mp3 mp3)
            throws Mp3LibraryDaoException {
        loadLibrary();
        Mp3 newMp3 = mp3s.put(title, mp3);
        writeLibrary();
        return newMp3;
    }

    @Override
    public List<Mp3> getAllMp3s()
            throws Mp3LibraryDaoException {
        loadLibrary();
        return new ArrayList(mp3s.values());
    }

    @Override
    public Mp3 getMp3(String title)
            throws Mp3LibraryDaoException {
        loadLibrary();
        return mp3s.get(title);
    }

    @Override
    public Mp3 removeMp3(String title)
            throws Mp3LibraryDaoException {
        loadLibrary();
        Mp3 removedMp3 = mp3s.remove(title);
        writeLibrary();
        return removedMp3;
    }

    @Override
    public Mp3 editMp3(String title, Mp3 mp3)
            throws Mp3LibraryDaoException {
        Mp3 editedMp3 = mp3s.replace(title, mp3);
        return editedMp3;
    }

    private Mp3 unmarshallMp3(String mp3AsText) {

        String[] mp3Tokens = mp3AsText.split(DELIMITER);

        String title = mp3Tokens[0];

        Mp3 mp3FromFile = new Mp3(title);

        // Index 1 - Artist
        mp3FromFile.setArtist(mp3Tokens[1]);

        // Index 2 - Album
        mp3FromFile.setAlbum(mp3Tokens[2]);

        // Index 3 - ReleaseDate    
        mp3FromFile.setReleaseDate(LocalDate.parse(mp3Tokens[3]));

        // Index 4 - Genre
        mp3FromFile.setGenre(mp3Tokens[4]);

        // Index 5 - Notes
        mp3FromFile.setNotes(mp3Tokens[5]);

        // We have now created a mp3! Return it!
        return mp3FromFile;
    }

    private void loadLibrary() throws Mp3LibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new Mp3LibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentMp3 holds the most recent mp3 unmarshalled
        Mp3 currentMp3;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Mp3 object by calling the unmarshallMp3 method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Mp3
            currentMp3 = unmarshallMp3(currentLine);

            // We are going to use the mp3 id as the map key for our mp3 object.
            // Put currentMp3 into the map using mp3 id as the key
            mp3s.put(currentMp3.getTitle(), currentMp3);
        }
        // close scanner
        scanner.close();
    }

    private String marshallMp3(Mp3 aMp3) {
        // We need to turn a Mp3 object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 
        // Start with the mp3 title, since that's supposed to be first.
        String mp3AsText = aMp3.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:
        // Artist
        mp3AsText += aMp3.getArtist() + DELIMITER;

        // Album
        mp3AsText += aMp3.getAlbum() + DELIMITER;

        // ReleaseDate
        
        mp3AsText += aMp3.getReleaseDate() + DELIMITER;

        // Genre - don't forget to skip the DELIMITER here.
        mp3AsText += aMp3.getGenre() + DELIMITER;

        // Notes - don't forget to skip the DELIMITER here.
        mp3AsText += aMp3.getNotes();

        // We have now turned a mp3 to text! Return it!
        return mp3AsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws Mp3LibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new Mp3LibraryDaoException(
                    "Could not save mp3 data.", e);
        }

        // Write out the Mp3 objects to the roster file.
        String mp3AsText;
        List<Mp3> mp3List = this.getAllMp3s();
        for (Mp3 currentMp3 : mp3List) {
            // turn a Student into a String
            mp3AsText = marshallMp3(currentMp3);
            // write the Student object to the file
            out.println(mp3AsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
