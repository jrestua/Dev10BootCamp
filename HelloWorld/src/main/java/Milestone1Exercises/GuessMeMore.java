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
import java.util.Random;

public class GuessMeMore {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        Random randomizer = new Random();
        
        int num = randomizer.nextInt(101 + 100) - 100;
        // max = 100; min = -100;
        int guessNum;
        String guessNumString = "";
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!: ");
        System.out.println("Your guess: " );
        guessNumString = myScanner.nextLine();
        guessNum = Integer.parseInt(guessNumString);
        
        
        if(guessNum == num){
            System.out.println("Wow, nice guess! That was it! The number was: " + num);
            }
        
        else if(guessNum < num){
            System.out.println("Ha, nice try - too low! I chose " + num);
            System.out.println("You chose: " + guessNum);
        }
        
        else{
            System.out.println("Too bad, way too high. I chose " + num);
            System.out.println("You chose: " + guessNum);
        }
    }
}