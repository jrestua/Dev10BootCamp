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

public class MiniMadLibs {
    public static void main(String[] args){
        
        String noun, adjective, noun2, num, adjective2, pluralNoun1, pluralNoun2, pluralNoun3, infiniteVerb, pastVerb;
        
        noun = "";
        adjective = "";
        noun2 = "";
        adjective2 = "";
        pluralNoun1 = "";
        pluralNoun2 = "";
        pluralNoun3 = "";
        infiniteVerb = "";
        pastVerb = "";
        num = "";
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String yourNoun = "";
        String yourAdjective = "";
        String yourNoun2 = "";
        String yourNum = "";
        String yourAdjective2 = "";
        String yourPluralNoun1 = "";
        String yourPluralNoun2 = "";
        String yourPluralNoun3 = "";
        String yourInfiniteVerb = "";
        String yourPastVerb = "";
        

        System.out.println("I need a noun: ");
        yourNoun = myScanner.nextLine();
        System.out.println("Now an adjective: ");
        yourAdjective = myScanner.nextLine();
        System.out.println("Another noun: ");
        yourNoun2 = myScanner.nextLine();
        System.out.println("And a number: ");
        yourNum = myScanner.nextLine();
        System.out.println("Another adjective: ");
        yourAdjective2 = myScanner.nextLine();
        System.out.println("A plural noun: ");
        yourPluralNoun1 = myScanner.nextLine();
        System.out.println("Another one: ");
        yourPluralNoun2 = myScanner.nextLine();
        System.out.println("One more: ");
        yourPluralNoun3 = myScanner.nextLine();
        System.out.println("A verb (infinitive form): ");
        yourInfiniteVerb = myScanner.nextLine();
        System.out.println("Same verb (past participle): ");
        yourPastVerb = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("*** NOW LETS GET MAD (libs) ***");
        System.out.println("");
        
        System.out.println(yourNoun + ": the " + yourAdjective + " frontier. These are the voyages"
        + " of the starship " + yourNoun2 + ". Its " + yourNum + "-year mission: to explore strange "
        + yourAdjective2 + " " + yourPluralNoun1 + ", to seek out " + yourAdjective2 + " " + yourPluralNoun2 + " and " + yourAdjective2 + " " + yourPluralNoun3 + 
        " , to boldly " + yourInfiniteVerb + " where no one has " + yourPastVerb + " before.");
    }
            
}
