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
import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = pickAColor(); // call color method here 
        String animal = pickAnAnimal(); // call animal method again here
        String colorAgain = pickAColor(); // call color method again here 
        
        int weight = pickNumber(200, 5); // call number method, 
            // with a range between 5 - 200 
        int distance = pickNumber(20, 10); // call number method, 
            // with a range between 10 - 20 
        int number = pickNumber(20000, 10000); // call number method, 
            // with a range between 10000 - 20000 
        int time = pickNumber(6, 2); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public static String pickAColor(){
        Random colorRandomizer = new Random();
        int colorNumber = colorRandomizer.nextInt(5) + 1;
            if(colorNumber == 1){
                return ("Red");
                }
            else if(colorNumber == 2){
                return ("Yellow");
                }
            else if(colorNumber == 3){
                return ("Green");
                }
            else if(colorNumber == 4){
                return ("Blue");
            }
            else{
                return ("Purple");
            }
    }
    
        public static String pickAnAnimal(){
        Random animalRandomizer = new Random();
        int animalNumber = animalRandomizer.nextInt(5) + 1;
            if(animalNumber == 1){
                return ("Dog");
                }
            else if(animalNumber == 2){
                return ("Cat");
                }
            else if(animalNumber == 3){
                return ("Bear");
                }
            else if(animalNumber == 4){
                return ("Monkey");
            }
            else{
                return ("Donkey");
            }
    }
        
        public static int pickNumber(int max, int min){
            return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    
    // ??? Method 3 ??? 
}
