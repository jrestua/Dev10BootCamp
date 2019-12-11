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
public class House2 {
    private double height;
    private double length;
    private double depth;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
    
    public static int sizeOfHouse(int height, int length, int width) {
        return height * length * width;
    }
    
    public static void main(String[] args){
        double volume = sizeOfHouse(5, 4, 3);
        System.out.println("The volume of the house is: " + volume);
    }
    
}
