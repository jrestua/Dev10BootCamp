/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmodeling;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class MethodsForRPS {
        //Method asking for number of rounds.
    public static int rounds(){
        Scanner myScanner = new Scanner(System.in);
        int rounds;
        
        System.out.println("Welcome to Rock, Paper, Scissor: ");
        System.out.println("How many rounds would you like to play?");
        String roundsString = myScanner.nextLine();
        rounds = Integer.parseInt(roundsString);
        if (rounds>0 && rounds<=10){
            System.out.println("We will be playing " + rounds + " ");
        }
        else{
            System.out.println("Error, number out of bounds. Goodbye.");
        }
        System.out.println("");
        return rounds;
    }
    
    
    //Method asking for user input. Rock, paper, or scissor.
    public static int userInput(){
        Scanner myScanner = new Scanner(System.in);
        
        int choice = 0;
        
        
        while (choice<=0 || choice>3) {
            System.out.println("Your turn. Type the number 1 for Rock. Type the number 2 for Paper. Type the number 3 for Scissors.: ");
            String choiceString = myScanner.nextLine();
            choice = Integer.parseInt(choiceString);
            if (choice<0 || choice>3){
                System.out.println("ERROR Please enter a valid age\n");
            }   
            else{
                if (choice == 1){
                    System.out.println("You chose rock.");
                    }
                if (choice == 2){
                    System.out.println("You chose paper.");
                    }
                if (choice == 3){
                    System.out.println("You chose scissors.");
                    }
                }
        }
        return choice;
        
        } 
    
    //Creates random input for computer.
    public static int randomInput(){
        Random rand = new Random();
        int randomInteger = rand.nextInt((3 - 1) + 1) + 1;;
         if (randomInteger == 1){
                System.out.println("Computer chose rock.");
            }
            if (randomInteger == 2){
                System.out.println("Computer chose paper.");
            }
            if (randomInteger == 3){
                System.out.println("Computer chose scissors.");
            }
        return randomInteger;
    }
}
