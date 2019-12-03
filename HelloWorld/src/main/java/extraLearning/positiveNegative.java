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

public class positiveNegative {
    public static void main (String[] args){
        int num;
        String numString;
        
        numString = "";
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Let me tell you if your number is even or odd: ");
        numString = myScanner.nextLine();
        num = Integer.parseInt(numString);
        
        if(num % 2 == 0){
            System.out.println("Your number is Even!");
        }
        else{
            System.out.println("Your number is odd!");
        }
    }
}
