/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joe
 */
package com.joe.classmodeling;

import java.util.Scanner;

public class RockPaperScissor2 {
    
    public static void main(String[] args){
        
        Scanner myScanner = new Scanner(System.in);
        
        //Declaring and Initializing Variables \
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;
        String playAgain = "y";
        
        //while loop to start game, also continues in loop if the user wants to play again.
        while(playAgain.equals("y")){
        //Calls for number of rounds user wants to play
        int numRounds = MethodsForRPS.rounds();
        //For loop to loop through the code depending on how many rounds user types in.       
        for(int i = 0; i < numRounds; ++i){
            int rockPaperOrScissors = MethodsForRPS.userInput();
            int computerInputChoice = MethodsForRPS.randomInput();
            
            //You win if your choice is greater than the computers.
            if((rockPaperOrScissors == 1 ) && (computerInputChoice == 3) ){
                System.out.println("You won this round!");
                userWins++;
            }
            //You lose if your choice is less than the computers.
            if((rockPaperOrScissors == 1 ) && (computerInputChoice == 2) ){
                System.out.println("The computer won this round!");
                computerWins++;
            }
            if((rockPaperOrScissors == 2 ) && (computerInputChoice == 1) ){
                System.out.println("You won this round!");
                computerWins++;
            }
            if((rockPaperOrScissors == 2 ) && (computerInputChoice == 3) ){
                System.out.println("The computer won this round!");
                computerWins++;
            }
             if((rockPaperOrScissors == 3 ) && (computerInputChoice == 2) ){
                System.out.println("You won this round!");
                computerWins++;
            }
            if((rockPaperOrScissors == 3 ) && (computerInputChoice == 1) ){
                System.out.println("The computer won this round!");
                computerWins++;
            }
            //Tie when both choices equal eachother.
            if(computerInputChoice == rockPaperOrScissors){
                System.out.println("It's a tie.");
                ties++;
            }
        }
        
        //Print summary
        System.out.println("Your win total: " + userWins);
        System.out.println("Computer win total: " + computerWins);
        System.out.println("Tie toal: " + ties);
        if(userWins > computerWins){
            System.out.println("You win the game!!!!!");
            System.out.println("");
            }
        if(computerWins > userWins){
            System.out.println("The computer won the game!!!!!");
            System.out.println("");
            }
         else{
            System.out.println("The game ended in a tie.");
            System.out.println("");
            }
        //Ask if you would like to play again.
        System.out.println("Would you like to play again? y/n: ");
        playAgain = myScanner.nextLine();
        if (playAgain.equals("n")){
            System.out.println("Thank you for playing!");
        }
    }
    }
    }
