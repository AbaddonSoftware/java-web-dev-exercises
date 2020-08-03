package org.launch.java.studios.quiz;

import java.util.Collections;
import java.util.List;

public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(String question, List<String> correctAnswer) {
        super(question, null, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        return question + "\nType a short answer (between 5 - 80 characters) below";
    }

    @Override
    public double totalCredit(String guess) {
        return this.getLowerCaseCorrectAnswer().contains(guess) ? 1 : 0;
    }

    @Override
    public String getAnswerResult(String guess) {
        return totalCredit(guess) == 1 ? "This is the correct answer!" : "This answer may need to be reviewed.";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        boolean characterCountInRange = guess.length() <= 80 && guess.length() >= 5;
        if(characterCountInRange) {
            return true;
        }
        System.out.println("Entry must be between 5 and 80 characters long.");
        return false;
    }
}
