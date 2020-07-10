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

    public String gradeQuiz(int correctAnswers, int totalQuestions) {
        double gradeNumber = (double)correctAnswers / (double)totalQuestions * 100;
        return "You got " +correctAnswers+ " out of " +totalQuestions+ " correct! You're total score is " +gradeNumber;
    }

    public void runQuiz() {
        Scanner input = new Scanner(System.in);
        System.out.println(quizName.toUpperCase()+ "\n");
        int correctAnswers = 0;
        int totalQuestions = questions.size();
        for (Question question : questions) {
            System.out.println(question.getFullQuestion());
            System.out.println("\nYour Answer: ");
            String answer = input.nextLine();
            correctAnswers += question.isCorrect(answer) ? 1 : 0;
            System.out.println(question.validateAnswer(answer));
        }
        System.out.println("\n" +gradeQuiz(correctAnswers, totalQuestions));
    }


}
