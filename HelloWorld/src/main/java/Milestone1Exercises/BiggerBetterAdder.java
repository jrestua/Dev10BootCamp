/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone1Exercises;
/**
 *
 * @author joe
 */

import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args){
        
        int apple, banana, orange, fruit;
        
        apple = 0;
        banana = 0;
        orange = 0;
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String redFruit = "";
        String yellowFruit = "";
        String orangeFruit = "";
        
        System.out.println("Please enter a number for apples:");
        redFruit = myScanner.nextLine();
        System.out.println("Please enter a number for banana:");
        yellowFruit = myScanner.nextLine();
        System.out.println("Please enter a number for orange:");
        orangeFruit = myScanner.nextLine();
        
        apple = Integer.parseInt(redFruit);
        banana = Integer.parseInt(yellowFruit);
        orange = Integer.parseInt(orangeFruit);
        
        fruit = apple + banana + orange;
        
        System.out.println(fruit);
    }
            
}
