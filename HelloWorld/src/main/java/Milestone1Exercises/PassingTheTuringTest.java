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

public class PassingTheTuringTest {
    public static void main(String[] args){
        
        String name, color, fruit;
        int num;
        
        name = "";
        color = "";
        fruit = "";
        
        num = 0;
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String yourName = "";
        String yourColor = "";
        String yourFruit = "";
        String yourNum = "";
        
        System.out.println("Hello there!");
        System.out.println("What's your name?:");
        yourName = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("Hi, " + yourName + "." + " What's your favorite color?:");
        yourColor = myScanner.nextLine();
        System.out.println("Huh, " + yourColor + "?" + " Mine's Electric Lime");
        System.out.println("");
        
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.println("What's YOUR favorite fruit, " + yourName + "?");
        yourFruit = myScanner.nextLine();
        System.out.println("Really? " + yourFruit + " That's wild!");
        System.out.println("");
        
        System.out.println("Speaking of favorites, what's your favorite number?");
        yourNum = myScanner.nextLine();
        System.out.println("");
        
        num = Integer.parseInt(yourNum);
        System.out.println(num + " is a cool number. Mine's -7.");
        int newNum = (num * -7);
        System.out.println("Did you know " + num + " * -7. " + newNum + ". That's a cool number too!");
        System.out.println("");
        System.out.println("Well, thanks for talking to me," + yourName + "!");
    }
            
}

