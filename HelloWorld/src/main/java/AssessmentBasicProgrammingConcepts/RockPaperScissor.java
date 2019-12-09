/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssessmentBasicProgrammingConcepts;

/**
 *
 * @author joe
 */
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    
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
        int numRounds = rounds();
        //For loop to loop through the code depending on how many rounds user types in.       
        for(int i = 0; i < numRounds; ++i){
            int rockPaperOrScissors = userInput();
            int computerInputChoice = randomInput();
            
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
    
    //Method asking for number of rounds.
    public static int rounds(){
        Scanner myScanner = new Scanner(System.in);
        int rounds;
        
        System.out.println("Welcome to Rock, Paper, Scissor: ");
        System.out.println("How many rounds would you like to play?");
        String roundsString = myScanner.nextLine();
        rounds = Integer.parseInt(roundsString);
        if (rounds>0 && rounds<=10){
            System.out.println("We will be playing " + rounds + " ");
        }
        else{
            System.out.println("Error, number out of bounds. Goodbye.");
        }
        System.out.println("");
        return rounds;
    }
    
    
    //Method asking for user input. Rock, paper, or scissor.
    public static int userInput(){
        Scanner myScanner = new Scanner(System.in);
        
        int choice = 0;
        
        
        while (choice<=0 || choice>3) {
            System.out.println("Your turn. Type the number 1 for Rock. Type the number 2 for Paper. Type the number 3 for Scissors.: ");
            String choiceString = myScanner.nextLine();
            choice = Integer.parseInt(choiceString);
            if (choice<0 || choice>3){
                System.out.println("ERROR Please enter a valid number.");
            }   
            else{
                if (choice == 1){
                    System.out.println("You chose rock.");
                    }
                if (choice == 2){
                    System.out.println("You chose paper.");
                    }
                if (choice == 3){
                    System.out.println("You chose scissors.");
                    }
                }
        }
        return choice;
        
        } 
    
    //Creates random input for computer.
    public static int randomInput(){
        Random rand = new Random();
        int randomInteger = rand.nextInt((3 - 1) + 1) + 1;;
         if (randomInteger == 1){
                System.out.println("Computer chose rock.");
            }
            if (randomInteger == 2){
                System.out.println("Computer chose paper.");
            }
            if (randomInteger == 3){
                System.out.println("Computer chose scissors.");
            }
        return randomInteger;
    }
    
    }
