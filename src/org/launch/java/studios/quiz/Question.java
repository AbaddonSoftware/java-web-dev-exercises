package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.List;

public abstract class Question {
    String question;
    List<String> possibleChoices;
    List<String> correctAnswer;

    public Question(String question, List<String> possibleChoices, List<String> correctAnswer) {
        this.question = question;
        this.possibleChoices = possibleChoices;
        this.correctAnswer = correctAnswer;
    }

    public abstract String getQuestion();

    public abstract List<String> getPossibleChoices();

    public abstract List<String> getCorrectAnswer();

    public abstract boolean isCorrect(String guess);

    public abstract String verifyCorrectAnswer(String guess);

}