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

public class TheCount {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
       
        int start;
        int end;
        int incre;
        
        String startString;
        String endString;
        String increString;
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        System.out.println("What number should I start with?: ");
        startString = myScanner.nextLine();
        start = Integer.parseInt(startString);
        System.out.println("");
        
        System.out.println("What number should I end with?: ");
        endString = myScanner.nextLine();
        end = Integer.parseInt(endString);
        System.out.println("");
        
        System.out.println("What I increment by: ");
        increString = myScanner.nextLine();
        incre = Integer.parseInt(increString);
        System.out.println("");
        
        
        for (int i = start; i < end; i += incre) {
            System.out.println(i + incre);
}
    }
}
