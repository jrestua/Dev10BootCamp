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

public class BewareTheKraken {
    public static void main(String[] args) {
        
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;
        String keepSwimming;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            //It still works when condition is changed to "true"
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }
            System.out.println("Would you like to keep swimming y/n?: ");
            keepSwimming = myScanner.nextLine();
            if(keepSwimming.equals("y")){
                // I can swim, really fast! 500ft at a time!
                depthDivedInFt += 1000;
            }
            else{
                break;
            }
        }
        
        
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
