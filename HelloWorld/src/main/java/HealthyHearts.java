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

public class HealthyHearts {
    public static void main(String[] args){
        
        int age;
        
        age = 0;
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String yourAge = "";
        
        System.out.println("How old age you?: ");
        yourAge = myScanner.nextLine();
        age = Integer.parseInt(yourAge);
        int maxHeartRate = 220 - age;
        double percent = .85;
        double targetHeartRate = maxHeartRate * percent;
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + targetHeartRate + ".");
    }
            
}
