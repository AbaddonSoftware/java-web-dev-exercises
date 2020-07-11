package org.launch.java.studios.quiz;

import java.util.Collections;
import java.util.List;

public class ParagraphQuestion extends ShortAnswerQuestion {

    public ParagraphQuestion(String question, List<String> correctAnswer) {
        super(question, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        return question + "\nType an answer up to 300 characters below";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        return guess.length() <= 500 && guess.length() >= 100;
    }
}
