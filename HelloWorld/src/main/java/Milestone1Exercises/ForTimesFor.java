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

public class ForTimesFor {
    public static void main(String[] args){
         Scanner myScanner = new Scanner(System.in);
         
         int num;
         int answer;
         int score = 0;
         
         String numString;
         String answerString;
         
         System.out.println("Which times table shall I recite?");
         numString = myScanner.nextLine();
         num = Integer.parseInt(numString);
         System.out.println("");
         
         for (int i = 0; i < 21; i++) {
             System.out.println(i + " * " + num + " is: ");
             answerString = myScanner.nextLine();
             answer = Integer.parseInt(answerString);
             if(answer == (i * num)){
                 System.out.println("Correct");
                 System.out.println("");
                 score++;
             }
             else{
                 System.out.println("Wrong");
                 System.out.println("");
             }
            }
         
         if(score < 10){
             System.out.println("You should study more!!!");
         }
         else if((score > 10) && (score <18)){
             System.out.println("You should study more!!!");
         }
         else{
             System.out.println("You scored over 90% Congrats");
         }
             
         
    }
}
