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

public class AllTheTrivia {
    public static void main(String[] args){
        
        String data, planet1, planet2, gas;
        
        data = "";
        planet1 = "";
        planet2 = "";
        gas = "";
        
        
        Scanner myScanner = new Scanner(System.in);
        
        String yourData = "";
        String yourPlanet1 = "";
        String yourPlanet2 = "";
        String yourGas = "";
        
        System.out.println("1,024 Gigabytes is equal to one what?:");
        yourData = myScanner.nextLine();
        System.out.println("In our Solar System, which is the only planet that rotates clockwise?:");
        yourPlanet1 = myScanner.nextLine();
        System.out.println("The largest volcano ever discovered in our Solar System is located on which planet?:");
        yourPlanet2 = myScanner.nextLine();
        System.out.println("What is the most abundant element in the earth's atmosphere?:");
        yourGas = myScanner.nextLine();
        System.out.println("");
        
        System.out.println("Wow, 1,024 Gigabytes is a "  + yourPlanet2);
        System.out.println("I didn't know that the largest ever volcano was discovered on " + yourData);
        System.out.println("That's amazing that  "  + yourPlanet1 + " is the most abundant element in the atmosphere...");
        System.out.println(yourGas + " is the only planet that rotates clockwise, neat!");
    }
            
}

