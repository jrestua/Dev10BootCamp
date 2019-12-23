/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.dao;

import com.joe.mp3library.dto.Mp3;
import java.util.List;

/**
 *
 * @author joe
 */
public interface Mp3LibraryDao {

    Mp3 addMp3(String title, Mp3 mp3) throws Mp3LibraryDaoException;

    List<Mp3> getAllMp3s() throws Mp3LibraryDaoException;

    Mp3 getMp3(String title) throws Mp3LibraryDaoException;

    Mp3 removeMp3(String title) throws Mp3LibraryDaoException;
    
    Mp3 editMp3(String title, Mp3 mp3) throws Mp3LibraryDaoException;

}
