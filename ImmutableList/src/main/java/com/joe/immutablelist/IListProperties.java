/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.immutablelist;

import java.util.Scanner;

/**
 *
 * @author joe
 */
public class IListProperties {
    int[] intArray;
    public IListProperties(int num){
        this.intArray = new int[num];
    }
    
    
 
  public void populateArray(){
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i<intArray.length; i++){
        System.out.println("Please enter value: ");
        intArray[i] = scanner.nextInt();
        System.out.println(intArray);
    }
        
  }
}
