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

public class GuessMe {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int num = 4;
        int guessNum;
        String guessNumString = "";
        
        System.out.println("Can you guess my number?: ");
        guessNumString = myScanner.nextLine();
        guessNum = Integer.parseInt(guessNumString);
        
        if(guessNum == num){
            System.out.println("Wow, nice guess! That was it!");
            }
        
        else if(guessNum < num){
            System.out.println("Ha, nice try - too low! I chose " + num);
        }
        
        else{
            System.out.println("Too bad, way too high. I chose " + num);
        }
    }
}
