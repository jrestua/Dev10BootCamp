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

public class TriviaNight {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int answer1;
        int answer2;
        int answer3;
        
        String answer1String = "";
        String answer2String = "";
        String answer3String = "";
        
        int score = 0;
        
        System.out.println("FIRST QUESTION!: ");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code");
        System.out.println("2) Assembly Language");
        System.out.println("3) C#");
        System.out.println("4) Machine Code");
        System.out.println("");
        answer1String = myScanner.nextLine();
        answer1 = Integer.parseInt(answer1String);
        System.out.println("Your answer is: " + answer1);
        System.out.println("");
        if(answer1 == 4){
            score++;
        }
        
        System.out.println("SECOND QUESTION!: ");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper");
        System.out.println("2) Alan Turing");
        System.out.println("3) Charles Babbage");
        System.out.println("4) Larry Page");
        System.out.println("");
        answer2String = myScanner.nextLine();
        answer2 = Integer.parseInt(answer2String);
        System.out.println("Your answer is: " + answer2);
        System.out.println("");
        if(answer2 == 2){
            score++;
        }
        
        System.out.println("LAST QUESTION! ");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity");
        System.out.println("2) The Battlestar Galactica");
        System.out.println("The USS Enterprise");
        System.out.println("4) The Millennium Falcon");
        System.out.println("");
        answer3String = myScanner.nextLine();
        answer3 = Integer.parseInt(answer3String);
        System.out.println("Your answer is: " + answer3);
        System.out.println("");
        if(answer3 == 3){
            score++;
        }
        
        System.out.println("You got " + score + " correct.");
        
    }
}
