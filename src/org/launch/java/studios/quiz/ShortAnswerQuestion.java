package org.launch.java.studios.quiz;

import java.util.Collections;
import java.util.List;

public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(String question, List<String> correctAnswer) {
        super(question, Collections.EMPTY_LIST, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        return question + "\nType a short answer (less than 80 characters) below";
    }

    @Override
    public double totalCredit(String guess) {
        return this.getLowerCaseCorrectAnswer().contains(guess.trim()) ? 1 : 0;
    }

    @Override
    public String getAnswerResult(String guess) {
        return totalCredit(guess) == 1 ? "This is the correct answer!" : "This answer may need to be reviewed.";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        return guess.length() < 80 && guess.length() >= 5;  //5 was an abitrary choice
    }
}
