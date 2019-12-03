
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

public class DoItBetter {
    public static void main(String[] args){
        
        int miles, hotdogs, languages;
        
        miles = 0;
        hotdogs = 0;
        languages = 0;
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String yourMiles = "";
        String yourHotdogs = "";
        String yourLanguages = "";
        
        System.out.println("How many miles can you run?: ");
        yourMiles = myScanner.nextLine();
        miles = Integer.parseInt(yourMiles);
        int betterMiles = miles * 2;
        System.out.println("Well I can run " + betterMiles);
        
        System.out.println("How many hotdogs can you eat?: ");
        yourHotdogs = myScanner.nextLine();
        hotdogs = Integer.parseInt(yourHotdogs);
        int betterHotdogs = hotdogs * 2;
        System.out.println("Well I can eat " + betterHotdogs);
        
        System.out.println("How many languages can you speak?: ");
        yourLanguages = myScanner.nextLine();
        languages = Integer.parseInt(yourLanguages);
        int betterLanguages = languages * 2;
        System.out.println("Well I can speak " + betterLanguages);
    }
            
}
