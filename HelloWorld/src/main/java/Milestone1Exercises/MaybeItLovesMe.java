package Milestone1Exercises;

import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args){
        Random randomizer = new Random();
        
        int daisyPetals = randomizer.nextInt((89 - 13) + 1) + 13;
        
        System.out.println("Well here goes nothing...");
        
        do{
            if (daisyPetals % 2 == 0){
                System.out.println("It loves me NOT!");
                daisyPetals--;
            }
            else{
                System.out.println("It LOVES me!");
                daisyPetals--;
            }
        } while (daisyPetals != 0);
    }
}
