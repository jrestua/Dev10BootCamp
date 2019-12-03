/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraLearning;

/**
 *
 * @author joe
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class greatestNumber {
    public static void main(String[] args){
        
        int num1, num2, num3;
        
        String num1String = "";
        String num2String = "";
        String num3String = "";
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Think of 3 numbers and I will tell you the greatest number:");
        System.out.println("Number 1: ");
        num1String = myScanner.nextLine();
        num1 = Integer.parseInt(num1String);
        
        System.out.println("Number 2: ");
        num2String = myScanner.nextLine();
        num2 = Integer.parseInt(num2String);
        
        System.out.println("Number 3: ");
        num3String = myScanner.nextLine();
        num3 = Integer.parseInt(num3String);
        
        int[] myList = new int[] { num1, num2, num3};
        
        int max = myList[0];
        
        for(int i = 1; i < myList.length;i++)
            {
		if(myList[i] > max){
                    max = myList[i];}
            }
        		
	System.out.println("The largest number is: " + max);
        
	}
}
