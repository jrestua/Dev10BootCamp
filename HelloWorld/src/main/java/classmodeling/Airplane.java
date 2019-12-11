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
public class Airplane {
    private String startEngine; 
    private String takeOff; 
    private String landing;
    private String goHigher;
    private String goLower;

    public String getStartEngine() {
        return startEngine;
    }

    public void setStartEngine(String startEngine) {
        this.startEngine = startEngine;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public String getGoHigher() {
        return goHigher;
    }

    public void setGoHigher(String goHigher) {
        this.goHigher = goHigher;
    }

    public String getGoLower() {
        return goLower;
    }

    public void setGoLower(String goLower) {
        this.goLower = goLower;
    }
    
    
}
