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

public class LazyTeenager {
    public static void main(String[] args){
        
        Random randomizer = new Random();
        int percent = randomizer.nextInt((100 - 1) + 1) + 1;
        
        int times = 1;
        
        do{
            if(percent > 80){
                System.out.println("Clean your room!! " + times + "x");
                System.out.println("FINE! I'LL CLEAN MY ROOM.");
                break;
            }
            else if(percent < 80){
                System.out.println("Clean your room!! " + times + "x");
                if(percent>80){
                    System.out.println("FINE! I'LL CLEAN MY ROOM.");
                }
                else{
                    times++;
                    percent += 5;
                }
            }
        }while(percent < 100);
        
        if(times>10){
            System.out.println("That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
        }
        else{
            System.out.println("Dont Test Me");
        }
    }
}
