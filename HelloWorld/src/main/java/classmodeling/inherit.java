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
import java.util.Scanner;

public class inherit {
    public static void main(String[] args){
        int ch;
        Scanner s = new Scanner(System.in);
        System.out.println("Type 1 Area of a Triange or Type 2 for Square");
        ch=s.nextInt();
        switch(ch){
            case 1: System.out.println("Area of triangle: ");
                Triangle t = new Triangle();
                t.getData();
                t.Display_area();
                break;
            case 2: System.out.println("Area of Square: ");
                Square s1 = new Square();
                s1.getData();
                s1.Display_area();
                break;
            default: System.out.println("Wrong choice");
                break;
        }
    }
}
