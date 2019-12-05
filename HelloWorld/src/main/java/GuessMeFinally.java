/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
import java.util.Scanner;
import java.util.Random;

public class GuessMeFinally {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        Random randomizer = new Random();
        
        int num = randomizer.nextInt((10 - 1) + 1) + 1;
        //int num = randomizer.nextInt(101 + 100) - 100;
        // max = 100; min = -100;
        int guessNum;
        String guessNumString = "";
        
        System.out.println("I've chosen a number between -10 and 10. Betcha can't guess it!: ");
        System.out.println("Your guess: " );
        guessNumString = myScanner.nextLine();
        guessNum = Integer.parseInt(guessNumString);
        
        do{
            if(guessNum == num){
                System.out.println("You got it on your first try!!!: ");
                
            }
            else if(guessNum != num){
                if(guessNum < num){
                    System.out.println("Ha, nice try - too low!");
                    System.out.println("You chose: " + guessNum);
                    System.out.println("Try Again: ");
                    System.out.println("Your guess: " );
                    guessNumString = myScanner.nextLine();
                    guessNum = Integer.parseInt(guessNumString);
                }
                else{
                    System.out.println("Too bad, way too high.");
                    System.out.println("You chose: " + guessNum);
                    System.out.println("Try Again: ");
                    System.out.println("Your guess: " );
                    guessNumString = myScanner.nextLine();
                    guessNum = Integer.parseInt(guessNumString);
                    
                }
            }
        }while(guessNum != num);
        
        System.out.println("Wow, nice guess! That was it! The number was: " + num);
    }
}
