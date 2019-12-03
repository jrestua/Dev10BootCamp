/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraLearning;

/**
 *
 * @author joe
 */
import java.util.Scanner;

public class ifStatement {
    public static void main (String[] args){
        
        Scanner myScanner = new Scanner(System.in);
        
        int myInt;
        String intString = "";
        
        System.out.println("Let me tell you if your number is between or outside of 10 and 20: ");
        intString = myScanner.nextLine();
        myInt = Integer.parseInt(intString);
        
        if(myInt < 10){
            System.out.println("Your number is less than 10.");
        }
        else if (myInt >20){
            System.out.println("Your number is greater than 20.");
        }
        else {
            System.out.println("Your number is in between 10 and 20.");
        }
        
    }
}
