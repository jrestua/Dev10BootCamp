/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Lesson5;

/**
 *
 * @author joe
 */
public class Grades {

    

    //declare variables
    int quizScore1;
    int quizScore2;
    int quizScore3;
    int averageGrade;
    
    public Grades(int quizScore1, int quizScore2, int quizScore3){
        this.quizScore1 = quizScore1;
        this.quizScore2 = quizScore2;
        this.quizScore3 = quizScore3;
    }

    public int getQuizScore1() {
        return quizScore1;
    }

    public void setQuizScore1(int quizScore1) {
        this.quizScore1 = quizScore1;
    }

    public int getQuizScore2() {
        return quizScore2;
    }

    public void setQuizScore2(int quizScore2) {
        this.quizScore2 = quizScore2;
    }

    public int getQuizScore3() {
        return quizScore3;
    }

    public void setQuizScore3(int quizScore3) {
        this.quizScore3 = quizScore3;
    }

    public int averageGrade(int quizScore1, int quizScore2, int quizScore3){      
        averageGrade = ((quizScore1 + quizScore2 + quizScore3)/3);
        return averageGrade;
    }


    
    @Override
    public String toString(){
        return ("Quiz Scores: " + quizScore1 + " || " + quizScore2 + " || " + quizScore3);
    }
    
}
