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
import java.util.InputMismatchException;
import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int year;
        String yearString = "";
        
        System.out.println("What year were you born?: ");
        yearString = myScanner.nextLine();
        year = Integer.parseInt(yearString);
        
        if(year < 2005){
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
            }
        
        if(year < 1995){
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        
        if(year < 1985){
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        
        if(year < 1975){
            System.out.println("AND,  the original Jurassic Park release is closer to the date of the first lunar landing than it is to today.");
        }
        
        if(year < 1965){
            System.out.println("AND, that the MASH TV series has been around for almost half a century!");
        }
        
        if(year >= 2005){
            System.out.println("You're too young to understand");
        }
    }
}