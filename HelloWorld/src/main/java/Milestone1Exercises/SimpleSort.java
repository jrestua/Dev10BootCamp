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
import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        
        for (int i = 0; i < firstHalf.length; i++){
            wholeNumbers[i] = firstHalf[i];
        }
        
        for (int i = 0; i < secondHalf.length; i++){
            wholeNumbers[i + 12] = secondHalf[i];
        }
        
        Arrays.sort(wholeNumbers);
        System.out.println(Arrays.toString(wholeNumbers));
    
    }
}