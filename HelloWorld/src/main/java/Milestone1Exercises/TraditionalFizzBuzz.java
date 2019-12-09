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

public class TraditionalFizzBuzz {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int num;
        
        String numString;
        
        int count = 0;
        
        System.out.println("How many fizzing and buzzing units do you need in your life? ");
        numString = myScanner.nextLine();
        num = Integer.parseInt(numString);

         
        for (int i = 0; i <= num; i++) {
            if (((i % 3 == 0) || (i % 5 == 0)) == false){
                System.out.println(i);
            }
            else{
                if((i % 3 == 0) && (i % 5 == 0)){
                    System.out.println("fizzbuzz");
                    count++;
                    }
                else if(i % 3 == 0){
                    System.out.println("fizz");
                    count++;
                    }
                else if(i % 5 == 0){
                    System.out.println("buzz");
                    count++;
                }
            }
        }
            System.out.println("TRADITION!!!!!");
    }
}
