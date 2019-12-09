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

public class ForTimes {
    public static void main(String[] args){
         Scanner myScanner = new Scanner(System.in);
         
         int num;
         String numString;
         
         System.out.println("Which times table shall I recite?");
         numString = myScanner.nextLine();
         num = Integer.parseInt(numString);
          System.out.println("");
         
         for (int i = 0; i < 16; i++) {
             System.out.println(i + " * " + num + " is: " + i * num);
            }
    }
}
