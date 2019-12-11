/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.classmodeling;

/**
 *
 * @author joe
 */
import java.util.Scanner;

public class App {
     
    public static void main(String[] args){
        
        Scanner myScanner = new Scanner(System.in);
        
        int a;
        int b;
        int operationType;
        String calculateAgain = "y";
        
        while(calculateAgain.equals("y")){
        System.out.println("Welcome to Simple Calculator.");
        System.out.println("Which operations would you like to perform?");
        System.out.println("Type 1 for Addition. Type 2 for Subtraction.");
        System.out.println("Type 3 for Multiplication. Type 4 for Division.");
        System.out.println("Type 5 to EXIT the program.");
        String operationTypeString = myScanner.nextLine();
        operationType = Integer.parseInt(operationTypeString);
        if(operationType == 5){
            System.out.println("Thank you for using the Simple Calculator. Good Bye!");
            System.exit(0);
            }
        else{
        System.out.println("");
        
        System.out.println("What's the first operand you would like to calculate?");
        String aString = myScanner.nextLine();
        a = Integer.parseInt(aString);
        System.out.println("What's the second operand you would like to calculate?");
        String bString = myScanner.nextLine();
        b = Integer.parseInt(bString);
        
        
        if(operationType == 1){
            System.out.println("Your calculation is equal to: " + SimpleCalculator.addition(a,b));
        }
        if(operationType == 2){
            System.out.println("Your calculation is equal to: " + SimpleCalculator.subtraction(a,b));
        }
        if(operationType == 3){
            System.out.println("Your calculation is equal to: " + SimpleCalculator.multiplication(a,b));
        }
        if(operationType == 4){
            System.out.println("Your calculation is equal to: " + SimpleCalculator.division(a,b));
        }
        System.out.println("Would you like anymore calculations? y/n: ");
        calculateAgain = myScanner.nextLine();
        System.out.println("");
        System.out.println("");
        if (calculateAgain.equals("n")){
            System.out.println("Thank you for using the simple calculator! Good Bye!");
        }
        
    }
}
}
}