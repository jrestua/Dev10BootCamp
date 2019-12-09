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

public class BirthStones {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        int num;
        String numString = "";
        
        System.out.println("Let me tell you your Birth Stone. From 1-12, what month were you born?: ");
        numString = myScanner.nextLine();
        num = Integer.parseInt(numString);
        
        if(num == 1){
            System.out.println("1 - January - Garnet");
            }
        
        else if(num == 2){
            System.out.println("2 - February - Amethyst");
            }
            
        else if(num == 3){
            System.out.println("3 - March - Aquamarine");
            }

        else if(num == 4){
            System.out.println("4 - April - Diamond");
            }
        
        else if(num == 5){
            System.out.println("5 - May - Emerald");
            }
        
        else if(num == 6){
            System.out.println("6 - June - Pearl");
            }
            
        else if(num == 7){
            System.out.println("7 - July - Ruby");
            }

        else if(num == 8){
            System.out.println("8 - August - Peridot");
            }
        
        else if(num == 9){
            System.out.println("9 - September - Sapphire");
            }
        
        else if(num == 10){
            System.out.println("10 - October - Opal");
            }
            
        else if(num == 11){
            System.out.println("11 - November - Topaz");
            }

        else if(num == 12){
            System.out.println("12 - December - Turquoise");
            }
        
        else{
            System.out.println("Your number is not 1-12!");
        }
    }
}
