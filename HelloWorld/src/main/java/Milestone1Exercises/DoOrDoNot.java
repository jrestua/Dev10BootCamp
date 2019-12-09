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

public class DoOrDoNot {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;
/*
        do {
            iDidIt = true;
            break;
        } while (doIt);
*/
while(doIt == true){
    iDidIt = true;
    break;
}

        if (doIt && iDidIt) {
            System.out.println("I did it!");
            //Prints when "y"
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
            //When made into a while loop, this is no longer true
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
            //Prints when "n"
        }
    }
}
