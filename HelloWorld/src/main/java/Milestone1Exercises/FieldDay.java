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

public class FieldDay {
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        String name1, name2, name3, name4, name5;
        
        name1 = "Baggins";
        name2 = "Dresden";
        name3 = "Howl";
        name4 = "Potter";
        name5 = "Vimes";
        
        System.out.print("What's your last name?: ");
        String yourName = myScanner.nextLine();
        
        
    if((yourName.compareTo(name1)) < 0){
        System.out.println("Aha! You're on the team Red Dragons!");
        }
    else if((yourName.compareTo(name1) > 0) && ((yourName.compareTo(name2) < 0))){
        System.out.println("Aha! You're on the team Dark Wizards!");
        }
    else if((yourName.compareTo(name2) > 0) && ((yourName.compareTo(name3) < 0))){
        System.out.println("Aha! You're on the team Moving Castles!");
        }
    else if((yourName.compareTo(name3) > 0) && ((yourName.compareTo(name4) < 0))){
        System.out.println("Aha! You're on the team Golden Snitches!");
        }
    else if((yourName.compareTo(name4) > 0) && ((yourName.compareTo(name5) < 0))){
        System.out.println("Aha! You're on the team Golden Snitches!");
        }
    else{
        System.out.println("Aha! You're on the team Black Holes!");
        }
    
    System.out.println("Good luck in the games!");
    
    }
}
