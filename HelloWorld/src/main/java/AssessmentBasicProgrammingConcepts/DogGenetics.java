/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssessmentBasicProgrammingConcepts;

/**
 *
 * @author joe
 */

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        int count = 5;
        int sum = 100;
        
        Random rand = new Random();
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("What is your dog's name?: ");
        String dogName = myScanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println("");

        int vals[] = new int[count];
        sum -= count;

        for (int i = 0; i < count-1; ++i) {
            vals[i] = rand.nextInt(sum);
            }
        
        vals[count-1] = sum;

        Arrays.sort(vals);
        for (int i = count-1; i > 0; --i) {
            vals[i] -= vals[i-1];
        }
        for (int i = 0; i < count; ++i) {
            ++vals[i]; 
        }

        int stBernard = vals[0];
        int chihuahua = vals[1];
        int dramaticRedNosedAsianPug = vals[2] ;
        int commonCur = vals[3];
        int kingDoberman = vals[4];
        
        System.out.println(stBernard + "% St. Bernard");
        System.out.println(chihuahua + "% Chihuahua");
        System.out.println(dramaticRedNosedAsianPug + "% Dramatic RedNosed Asian Pug");
        System.out.println(commonCur + "% Common Cur");
        System.out.println(kingDoberman + "% King Doberman");
        System.out.println("Wow, that's QUITE the dog!  ");
    }
}