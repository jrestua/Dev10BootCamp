/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class MenuOfChampions {
    public static void main (String[] args){
        double pizza, pie, omelet;
        
        pizza = 500.00;
        pie = 2.00;
        omelet = 1.50;
        
        System.out.println("WELCOME TO RESTAURANT NIGHT VALE!");
        System.out.println("Today's Menu Is...");
        System.out.println(" ");
        
        System.out.print("Slice of Big Rico Pizza $");
        System.out.printf("%.2f", pizza);
        System.out.println(" ");
        
        System.out.print("Invisible Strawberry Pie $");
        System.out.printf("%.2f", pie);
        System.out.println(" ");
        
        System.out.print("Denver Omelet $");
        System.out.printf("%.2f", omelet);
    }
            
}
