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

public class doWhile {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        
        do {
            System.out.println("Enter a number: ");
            value = scanner.nextInt();
        }
        while(value != 5);
        
        System.out.println("Your number is 5!!!");
        
    }
}
