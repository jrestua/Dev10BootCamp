/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.mp3library.dao;

/**
 *
 * @author joe
 */
public class Mp3LibraryDaoException extends Exception{
    
    public Mp3LibraryDaoException(String message) {
        super(message);
    }
    
    public Mp3LibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}