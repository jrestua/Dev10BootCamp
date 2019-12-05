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

public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        String dontKeepRiding = "n";
        int loopsLooped = 0;
        //while (keepRiding.equals("y")) {
        while (dontKeepRiding.equals("n")) {
            //when changed to check for "n", it does the opposite, gets off at "y"
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            //keepRiding = userInput.nextLine();
            dontKeepRiding = userInput.nextLine();
            loopsLooped++;
            //No int in front of loopsLooped because we already declared it before the while loop
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}