/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            //starting point 0, end point 9
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            //starting point 10, end point 1
            System.out.print(i + ", ");
        }
    }
}
