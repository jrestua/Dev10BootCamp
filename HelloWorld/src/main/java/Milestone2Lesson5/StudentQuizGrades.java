/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Lesson5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joe
 */
public class StudentQuizGrades extends UserIOConsoleImpl {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashMap<String, Grades> grades = new HashMap<>();
        grades.put("Joseph", new Grades(100, 95, 99));
        grades.put("Caleb", new Grades(78, 80, 90));
        grades.put("Chris", new Grades(100, 85, 92));

        Set<String> keys = grades.keySet();
        //Prints Students and Grades
        System.out.println("Student and Quiz Scores");
        for (String currentKey : keys) {
            Grades scores = grades.get(currentKey);
            System.out.println(currentKey
                    + " = " + scores);
        }
        System.out.println("");

        //Adding Student
        System.out.println("Would you like to add any students? y/n");
        String addingStudents = s.nextLine();

        String student;
        int grade1;
        int grade2;
        int grade3;

        if (addingStudents.equals("y")) {
            String addAgain;
            do {
                System.out.println("What is the students name?: ");
                student = s.nextLine();
                System.out.println("Students name is: " + student);
                System.out.println("");

                System.out.println("What is the first score?: ");
                String grade1String = s.nextLine();
                grade1 = Integer.parseInt(grade1String);
                System.out.println("Score 1: " + grade1);
                System.out.println("");

                System.out.println("What is the second score?: ");
                String grade2String = s.nextLine();
                grade2 = Integer.parseInt(grade2String);
                System.out.println("Score 2: " + grade2);
                System.out.println("");

                System.out.println("What is the third score?: ");
                String grade3String = s.nextLine();
                grade3 = Integer.parseInt(grade3String);
                System.out.println("Score 3: " + grade3);
                System.out.println("");
                grades.put(student, new Grades(grade1, grade2, grade3));

                System.out.println("Would you like to add any more students? y/n");
                addAgain = s.nextLine();

            } while (addAgain.equals("y"));
        }

        //Removing Student
        System.out.println("Would you like to remove any students? y/n");
        String removingStudents = s.nextLine();
        if (removingStudents.equals("y")) {
            String removeAgain;
            do {
                System.out.println("What is the students name?: ");
                student = s.nextLine();
                System.out.println("Students name is: " + student);
                System.out.println("");
                grades.remove(student);
                System.out.println("Would you like to remove any more students? y/n");
                removeAgain = s.nextLine();
            } while (removeAgain.equals("y"));
        }

        //Average grade for given student
        System.out.println("Would you like the average score for a student? y/n");
        String averageStudent = s.nextLine();
        if (averageStudent.equals("y")) {
            String averageOfAnother;
            do {
                System.out.println("What is the students name?: ");
                student = s.nextLine();
                System.out.println("");
                for (String studentName : grades.keySet()) {
                    Grades score = grades.get(studentName);                    
                    if(studentName.equals(student)){
                        System.out.println("Name = " + studentName + ", Grades = " + score);
                        //Calculate avg scores
                    }
                }
                System.out.println("Would you like another students average? y/n");
                averageOfAnother = s.nextLine();
            } while (averageOfAnother.equals("y"));
        }

        //Prints Student and Scores
        System.out.println("Student and Quiz Scores");
        for (String currentKey : keys) {
            Grades scores = grades.get(currentKey);
            System.out.println(currentKey
                    + " = " + scores);
        }
        System.out.println("");

    }

}
