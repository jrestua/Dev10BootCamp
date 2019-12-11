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
class Shape{
    public double len,bre;
    Shape(){
        len = 0;
        bre = 0;
    }
    public void getData(){
        System.out.println("Enter the two values: ");
        Scanner s = new Scanner(System.in);
        len=s.nextDouble();
        bre=s.nextDouble();
    }
    public void Display_area(){
    
    }
}
