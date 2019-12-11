/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.classmodeling;


import java.util.Scanner;

/**
 *
 * @author joe
 */
class Triangle extends Shape{
    double area;
    public void getData(){
        System.out.println("Enter the two values: ");
        Scanner s = new Scanner(System.in);
        len = s.nextDouble();
        bre = s.nextDouble();
    }
    public void Display_area(){
        area=(0.5 * len * bre);
        System.out.println("Area is: " + area);
    }
}