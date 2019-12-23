/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.enums;

import java.util.Scanner;

/**
 *
 * @author joe
 */
public class App {
        public static void main(String[] args) {

        IntMath math = new IntMath();
        Scanner myScanner = new Scanner(System.in);
        
        MathOperator operator = null;
        

        System.out.println("What operator would you like to use? (plus/minus/multiply/divide) ");
        String pickAnOperator = myScanner.nextLine();
        if (pickAnOperator.equals("plus")) {
            operator = MathOperator.PLUS;
        }
        if (pickAnOperator.equals("minus")) {
            operator = MathOperator.MINUS;
        }
        if (pickAnOperator.equals("multiply")) {
            operator = MathOperator.MULTIPLY;
        }
        if (pickAnOperator.equals("divide")) {
            operator = MathOperator.DIVIDE;
        }

        System.out.println("You chose: " + pickAnOperator);

        System.out.println("What is your FIRST integer? ");
        String operand1String = myScanner.nextLine();
        int operand1 = Integer.parseInt(operand1String);

        System.out.println("What is your SECOND integer? ");
        String operand2String = myScanner.nextLine();
        int operand2 = Integer.parseInt(operand2String);
        System.out.println(math.calculate(operator, operand1, operand2));
    }

}
