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
class Square extends Shape{
    double area;
    public void getData(){
        System.out.println("Enter the value of 1 side: ");
        Scanner s = new Scanner(System.in);
        len = s.nextDouble();
        bre = s.nextDouble();
    }
    public void Display_area(){
        area=(len * bre);
        System.out.println("Area is: " + area);
    }
}
