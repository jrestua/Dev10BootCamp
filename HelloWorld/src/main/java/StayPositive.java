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

public class StayPositive {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int yourNum;
        String yourNumString = "";
        
        System.out.println("What number should I count down from? ");
        yourNumString = myScanner.nextLine();
        yourNum = Integer.parseInt(yourNumString);
        System.out.println("");
        
        System.out.println("Here goes!");
        System.out.println("");
        
        while (yourNum != -1) {
            System.out.print(yourNum + " ");
            yourNum--; // Time passes
            //When commenting out the above line, the while loop keeps going and doesnt stop
        }
    }
}
