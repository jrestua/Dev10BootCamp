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
import java.util.Scanner;

public class DogGenetics {
    
    Random randomGenetics = new Random();
    Scanner myScanner = new Scanner(System.in);
    
    public void main(String[] args){
        
        randomFill();
        report100();
        
    }
    
    public static int randomFill(){
        Random rand = new Random();
        int randomNum = rand.nextInt();
        return randomNum;
    }
    
    public int[] report100() {
        int sum = 0;
        int total = 100;
        
        int[] report = new int[5];
        for(int i=0;i<report.length;i++){
            report[i] = randomFill();
        }
        for (int i = 0; i < report.length; i++){
            sum +=  report[i]; 
            if(sum == total){ 
                print(report);
            }
            else{
                report100();
            }   
        }
        return null;
        }
    
    
    public void print(int[] report){    
        
        int stBernard = report[0] ;
        int chihuahua = report[1] ;
        int dramaticRedNosedAsianPug = report[2] ;
        int commonCur = report[3] ;
        int kingDoberman = report[4] ;
        
        
        System.out.println("What is your dog's name?: ");
        String dogName = myScanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println("");
        System.out.println(stBernard + "% St. Bernard");
        System.out.println(chihuahua + "% Chihuahua");
        System.out.println(dramaticRedNosedAsianPug + "% Dramatic RedNosed Asian Pug");
        System.out.println(commonCur + "% Common Cur");
        System.out.println(kingDoberman + "% King Doberman");
        System.out.println("Wow, that's QUITE the dog!  ");
    }
    
   
    
    
}
