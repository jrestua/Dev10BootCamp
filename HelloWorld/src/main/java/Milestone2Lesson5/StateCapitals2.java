/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joe
 */
public class StateCapitals2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // create a map that maps a state to its capital
        HashMap<String, Capital> stateCapitals = new HashMap<>();

        // add the first state and capital
        stateCapitals.put("Alabama", new Capital("Montgomery", 205000, 156));

        // add the next state and capital
        stateCapitals.put("Alaska", new Capital("Juneau", 31000, 3255));

        // add the next state and capital
        stateCapitals.put("Arizona", new Capital("Phoenix", 1445000, 517));

        // add the next state and capital
        stateCapitals.put("Arkansas", new Capital("Little Rock", 193000, 116));

        // get the Set of keys from the map
        Set<String> keys = stateCapitals.keySet();

        System.out.println("State Capital Pairs");
        for (String currentKey : keys) {
            Capital keyCapital = stateCapitals.get(currentKey);
            System.out.println("State: " + currentKey + keyCapital);
        }

        System.out.println("");
        System.out.println("Please enter the lower limit for capital city population: ");
        int minPopSize = s.nextInt();
        System.out.println("");
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + minPopSize + ": ");
        for (String currentKey : keys) {
            Capital keyCapital = stateCapitals.get(currentKey);
            if (keyCapital.population > minPopSize) {
                System.out.println("State: " + currentKey + keyCapital);
            }
        }

    }
}
