/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author joe
 */
public class StateCapitals {
    public static void main(String[] args){
        
    // create a map that maps a state to its capital
    HashMap<String, String> stateCapitals = new HashMap<>();
       
    // add the first state and capital
    stateCapitals.put("Alabama", "Montgomery");
       
     // add the next state and capital
    stateCapitals.put("Alaska", "Juneau");
       
     // add the next state and capital
    stateCapitals.put("Arizona", "Phoenix");
       
    // add the next state and capital
    stateCapitals.put("Arkansas", "Little Rock");
    
    
    // get the Set of keys from the map
    Set<String> keys = stateCapitals.keySet();
       
    //Prints states
    System.out.println("State");
    for (String currentKey : keys) {
        String keyCapital= stateCapitals.get(currentKey);
        System.out.println(currentKey);        
//        System.out.println("The capital of " + currentKey + 
//              " is " + keyCapital);
    }
    
    System.out.println("");  
    
        //Prints capitals
    System.out.println("Capitals");
    for (String currentKey : keys) {
        String keyCapital= stateCapitals.get(currentKey);
        System.out.println(keyCapital);        
    }
    
        System.out.println("");  
    
        //Prints both state and capital
    System.out.println("State and Capital");
    for (String currentKey : keys) {
        String keyCapital= stateCapitals.get(currentKey);
        System.out.println("The capital of " + currentKey + 
        " is " + keyCapital);      
    }
    

    }
}
