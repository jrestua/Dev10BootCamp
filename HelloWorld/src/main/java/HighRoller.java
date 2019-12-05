/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */

import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        int sideOfDice;
        
        System.out.println("How many sides does this dice have? ");
        String sideDiceString = myScanner.nextLine();
        sideOfDice = Integer.parseInt(sideDiceString);
        

        //int rollResult = diceRoller.nextInt(6) + 1;
        
        int rollResult = diceRoller.nextInt(sideOfDice) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        else if (rollResult == sideOfDice){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
}
