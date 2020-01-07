/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.flooringmastery.ui;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_UP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author joe
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String intput = myScanner.nextLine();
        double doubleVal = Double.parseDouble(intput);

        return doubleVal;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        String stringNumber = myScanner.nextLine();
        double number = Double.parseDouble(stringNumber);

        while (number < min || number > max) {

            if (number < min || number > max) {
                System.out.println("Please input the correct number");
                stringNumber = myScanner.nextLine();
                number = Double.parseDouble(stringNumber);
            }
        }
        return number;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String intput = myScanner.nextLine();
        float floatVal = Float.parseFloat(intput);

        return floatVal;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {

        System.out.println(prompt);
        String stringNumber = myScanner.nextLine();
        float number = Float.parseFloat(stringNumber);

        while (number < min || number > max) {

            if (number < min || number > max) {
                System.out.println("Please input the correct number");
                stringNumber = myScanner.nextLine();
                number = Float.parseFloat(stringNumber);
            }
        }
        return number;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String intput = myScanner.nextLine();
        int intVal = Integer.parseInt(intput);

        return intVal;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        String stringNumber = myScanner.nextLine();
        int number = Integer.parseInt(stringNumber);

        while (number < min || number > max) {

            if (number < min || number > max) {
                System.out.println("Please input the correct number");
                stringNumber = myScanner.nextLine();
                number = Integer.parseInt(stringNumber);
            }
        }
        return number;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String intput = myScanner.nextLine();
        long longVal = Long.parseLong(intput);

        return longVal;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String stringNumber = myScanner.nextLine();
        long number = Long.parseLong(stringNumber);

        while (number < min || number > max) {

            if (number < min || number > max) {
                System.out.println("Please input the correct number");
                stringNumber = myScanner.nextLine();
                number = Long.parseLong(stringNumber);
            }
        }
        return number;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();

        return input;
    }
    
        @Override
    public BigDecimal readBigDecimal(String prompt, int scale) {
        boolean valid = false;
        BigDecimal result = null;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value).setScale(scale, ROUND_UP);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a number.\n", value);
            }
        } while (!valid);
        return result;
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt, int scale, BigDecimal min) {
        boolean valid = false;
        BigDecimal result = null;
        do {
            result = readBigDecimal(prompt, scale);
            if (result.compareTo(min) >= 0) {
                valid = true;
            } else {
                String minString = String.valueOf(min);
                System.out.printf("The value must be greater than %s.\n", minString);
            }
        } while (!valid);
        return result;
    }
    
    @Override
    public LocalDate readLocalDate(String prompt){
        return LocalDate.parse(readString(prompt), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    
    @Override
    public LocalDate readLocalDate(String prompt, LocalDate min) {
                boolean valid = false;
        LocalDate result = null;
        do {
            result = readLocalDate(prompt);
            if (result.isAfter(min)) {
                valid = true;
            } else {
                System.out.printf("Please choose a date within bounds. (%s to %s)\n", min);
            }
        } while (!valid);
        return result;
    }

}

