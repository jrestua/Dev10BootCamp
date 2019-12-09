/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class LovesMe {
    public static void main (String[] args){
        int daisyPetals = 34;
        
        System.out.println("Well here goes nothing...");
        
        do{
            if (daisyPetals % 2 == 0){
                System.out.println("It loves me NOT!");
                daisyPetals--;
            }
            else{
                System.out.println("It LOVES me!");
                daisyPetals--;
            }
        } while (daisyPetals != 0);
    } 
}
