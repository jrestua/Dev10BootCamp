/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.dao;

import com.joe.mp3library.dto.Mp3;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joe
 */
public class Mp3LibraryDaoTest {
    
    private Mp3LibraryDao dao = new Mp3LibraryDaoFileImpl();
    
    
    public Mp3LibraryDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        List<Mp3>mp3List = dao.getAllMp3s();
        for(Mp3 mp3: mp3List){
            dao.removeMp3(mp3.getTitle());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMp3 method, of class Mp3LibraryDao.
     */
    @Test
    public void testAddGetMp3() throws Exception {
        Mp3 mp3 = new Mp3("Love");
        mp3.setArtist("Keiysha Cole");
        mp3.setAlbum("Greatest Hits");
        mp3.setReleaseDate(LocalDate.of(2014, Month.JANUARY, 1));
        mp3.setGenre("Rnb");
        mp3.setNotes("N/a");
        
        dao.addMp3(mp3.getTitle(), mp3);
        Mp3 fromDao = dao.getMp3(mp3.getTitle());
        assertEquals(mp3, fromDao);
    }

    /**
     * Test of getAllMp3s method, of class Mp3LibraryDao.
     */
    @Test
    public void testGetAllMp3s() throws Exception {
        Mp3 mp3 = new Mp3("Love");
        mp3.setArtist("Keiysha Cole");
        mp3.setAlbum("Greatest Hits");
        mp3.setReleaseDate(LocalDate.of(2014, Month.JANUARY, 1));
        mp3.setGenre("Rnb");
        mp3.setNotes("N/a");
        
        dao.addMp3(mp3.getTitle(), mp3);
        
        Mp3 mp32 = new Mp3("I Remember");
        mp32.setArtist("Keiysha Cole");
        mp32.setAlbum("Greatest Hits");
        mp32.setReleaseDate(LocalDate.of(2014, Month.JANUARY, 1));
        mp32.setGenre("Rnb");
        mp32.setNotes("N/a");
        
        dao.addMp3(mp3.getTitle(), mp32);
        
        assertEquals(2, dao.getAllMp3s().size());
    }

    /**
     * Test of removeMp3 method, of class Mp3LibraryDao.
     */
    @Test
    public void testRemoveMp3() throws Exception {
         Mp3 mp3 = new Mp3("Love");
        mp3.setArtist("Keiysha Cole");
        mp3.setAlbum("Greatest Hits");
        mp3.setReleaseDate(LocalDate.of(2014, Month.JANUARY, 1));
        mp3.setGenre("Rnb");
        mp3.setNotes("N/a");
        
        dao.addMp3(mp3.getTitle(), mp3);
        
        Mp3 mp32 = new Mp3("I Remember");
        mp32.setArtist("Keiysha Cole");
        mp32.setAlbum("Greatest Hits");
        mp32.setReleaseDate(LocalDate.of(2014, Month.JANUARY, 1));
        mp32.setGenre("Rnb");
        mp32.setNotes("N/a");
        
        dao.addMp3(mp3.getTitle(), mp32);
        
        dao.removeMp3(mp3.getTitle());
        assertEquals(1, dao.getAllMp3s().size());
        assertNull(dao.getMp3(mp3.getTitle()));
        
        dao.removeMp3(mp32.getTitle());
        assertEquals(0, dao.getAllMp3s().size());
        assertNull(dao.getMp3(mp32.getTitle()));
    }

    /**
     * Test of editMp3 method, of class Mp3LibraryDao.
     */
    @Test
    public void testEditMp3() throws Exception {
    }

    
}
