package Milestone1Exercises;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
import java.util.Arrays;

public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple",
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange",
            "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange",
            "Apple", "Orange", "Orange"};

        // Fruit sorting code goes here!
        int total = 0;
        int countApples = 0;
        int countOranges = 0;
        
        int startIndex = 0;
        
        String[] oranges = new String[countOranges];
        String[] apples = new String[countApples];
        
        Arrays.sort(fruit);
        
        for (int i = 0; i < countApples; i++){
            apples[i] = fruit[i];
        }
        
        for (int i = 0; i < fruit.length; i++){
            oranges[i + countApples ] = fruit[i];
        }
        
        
        for (int i = 0; i < fruit.length; i++){
                if(fruit[i].equals("Orange")){
                    countOranges++;
                    total++;
                }
                else{
                    countApples++;
                    total++;
                }
                
            }
        System.out.println("Count of Oranges: " + countOranges);
        System.out.println("Count of Apples: " + countApples);
        System.out.println("Total: " + total);
        System.out.println(Arrays.toString(fruit));
        System.out.println(Arrays.toString(apples));
        System.out.println(Arrays.toString(oranges));
        
        
    }
}

