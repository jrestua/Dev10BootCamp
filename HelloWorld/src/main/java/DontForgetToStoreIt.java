/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */

//Hard Time Understanding
import java.util.Scanner;

public class DontForgetToStoreIt {

    public static void main(String[] args) {

        int meaningOfLifeAndEverything = 42;
        double pi = 3.14159;
        String cheese, color;
        
        
        String pii = "";
        String meaningOfLifeAndEverythingg = "";
        String cheesee = "";
        String colorr = "";

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Give me pi to at least 5 decimals: ");
        inputReader.nextLine();
        pii = inputReader.nextLine();

        System.out.println("What is the meaning of life, the universe & everything? ");
        inputReader.nextLine();
        meaningOfLifeAndEverythingg = inputReader.nextLine();

        System.out.println("What is your favorite kind of cheese? ");
        inputReader.nextLine();
        cheesee = inputReader.nextLine();

        System.out.println("Do you like the color red or blue more? ");
        inputReader.nextLine();
        colorr = inputReader.nextLine();
        
        pi = Integer.parseInt(pii);
        meaningOfLifeAndEverything = Integer.parseInt(meaningOfLifeAndEverythingg);
        

            System.out.println("Ooh, " + colorr + " " + cheesee +" sounds delicious!");
            System.out.println("The circumference of life is " +( 2 * pi * meaningOfLifeAndEverything));
    }
}
