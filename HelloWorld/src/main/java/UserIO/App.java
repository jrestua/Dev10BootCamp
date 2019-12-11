/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;

/**
 *
 * @author joe
 */
import java.util.Scanner;

public class App extends UserIOConsoleImpl{
     
    public static void main(String[] args){
        
        UserIOConsoleImpl userIO = new UserIOConsoleImpl();
        
        int a ;
        int b;
        int operationType;
        String calculateAgain = "y";
        
        while(calculateAgain.equals("y")){
        userIO.print("Welcome to Simple Calculator.");
        userIO.print("Which operations would you like to perform?");
        userIO.print("Type 1 for Addition. Type 2 for Subtraction.");
        userIO.print("Type 3 for Multiplication. Type 4 for Division.");
        userIO.print("Type 5 to EXIT the program.");
        operationType = userIO.readInt("What's your operation");
        if(operationType == 5){
            userIO.print("Thank you for using the Simple Calculator. Good Bye!");
            System.exit(0);
            }
        else{
        userIO.print("");
        
        a = userIO.readInt("What's the first operand you would like to calculate?");
        b = userIO.readInt("What's the second operand you would like to calculate?");
        
        
        if(operationType == 1){
            userIO.print("Your calculation is equal to: " + SimpleCalculator.addition(a,b));
        }
        if(operationType == 2){
            userIO.print("Your calculation is equal to: " + SimpleCalculator.subtraction(a,b));
        }
        if(operationType == 3){
            userIO.print("Your calculation is equal to: " + SimpleCalculator.multiplication(a,b));
        }
        if(operationType == 4){
            userIO.print("Your calculation is equal to: " + SimpleCalculator.division(a,b));
        }
        calculateAgain = userIO.readString("Would you like anymore calculations? y/n: ");
        userIO.print("");
        userIO.print("");
        if (calculateAgain.equals("n")){
            userIO.print("Thank you for using the simple calculator! Good Bye!");
        }
        
    }
}
}
}
