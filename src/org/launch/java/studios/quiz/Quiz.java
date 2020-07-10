package org.launch.java.studios.quiz;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    String quizName;
    List<Question> questions;

    public Quiz(String quizName, List<Question> questions) {
        this.quizName = quizName;
        this.questions = questions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question aQuestion) {
        questions.add(aQuestion);
    }

    public String gradeQuiz(double correctAnswers, double totalQuestions) {
        double gradeNumber = correctAnswers / totalQuestions * 100;
        return "You got " +correctAnswers+ " out of " +totalQuestions+ " correct! You're total score is " +gradeNumber;
    }

    public void runQuiz() {
        Scanner input = new Scanner(System.in);
        System.out.println(quizName.toUpperCase());
        double correctAnswers = 0;
        double totalQuestions = questions.size();
        for (Question question : questions) {
            System.out.println("\n" +question.getFullQuestion());
            System.out.println("\nYour Answer: ");
            String answer = input.nextLine();
            correctAnswers += question.totalCredit(answer);
            System.out.println("\n" +question.validateAnswer(answer));
        }
        System.out.println("\n" +gradeQuiz(correctAnswers, totalQuestions));
    }


}
