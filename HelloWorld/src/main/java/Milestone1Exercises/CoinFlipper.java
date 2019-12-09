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
import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args){
        Random randomizer = new Random();
        boolean isValid = true;
        
        
        System.out.println("Ready, Set, Flip....!!");
        if (randomizer.nextBoolean() == isValid){
            System.out.println("You got Heads!");
        }
        else{
            System.out.println("You got Tails!");
        }
    }
}
