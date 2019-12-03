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

public class switches {
    
    public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Please enter a command: ");
    String text = input.nextLine();
    
    switch(text){
        case "start":
            System.out.println("Machine started.");
            break;
        case "stop":
            System.out.println("Machine has stopped.");
            break;
        default:
            System.out.println("Command not recognized.");
       }
    }
    
}
