/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.classmodeling;

/**
 *
 * @author joe
 */
public class Book {
    private String hardCover;
    private String softCover;
    private String text;
    private String paperType;

    public String getHardCover() {
        return hardCover;
    }

    public void setHardCover(String hardCover) {
        this.hardCover = hardCover;
    }

    public String getSoftCover() {
        return softCover;
    }

    public void setSoftCover(String softCover) {
        this.softCover = softCover;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }
    
    
}
