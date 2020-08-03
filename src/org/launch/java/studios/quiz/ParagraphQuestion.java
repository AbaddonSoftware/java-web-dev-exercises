package org.launch.java.studios.quiz;

import java.util.List;

public class ParagraphQuestion extends ShortAnswerQuestion {

    public ParagraphQuestion(String question, List<String> correctAnswer) {
        super(question, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        return question + "\nType an answer between 25-500 characters below";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        boolean characterCountInRange = guess.length() <= 500 && guess.length() >= 25;
        if(characterCountInRange) {
            return true;
        }
        System.out.println("Entry must be between 25 and 500 characters long.");
        return false;
    }
}
