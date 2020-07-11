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

    public String simpleGradeQuiz(double correctAnswers, double totalQuestions) {
        double gradeNumber = correctAnswers / totalQuestions * 100;
        return String.format("You got %.2f out %.0f of correct! You're total score is %.2f%n", correctAnswers, totalQuestions, gradeNumber);
    }

    public void runQuiz() {
        Scanner input = new Scanner(System.in);
        System.out.println(quizName.toUpperCase());
        double correctAnswers = 0;
        double totalQuestions = questions.size();
        String answer;
        for (Question question : questions) {
            System.out.println("\n" +question.getFullQuestion());
            do {
                System.out.println("\nYour Answer: ");
                answer = input.nextLine();
            } while (!question.isFormattedAnswer(answer));
            correctAnswers += question.totalCredit(answer);
            //System.out.println(question.getAnswerResult(answer));
        }
        System.out.println("\n" +simpleGradeQuiz(correctAnswers, totalQuestions));
    }


}
