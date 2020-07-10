package org.launch.java.studios.quiz;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class BooleanQuestion extends MultipleChoiceQuestion {

    public BooleanQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    public BooleanQuestion(String question, Boolean correctAnswer) {
        super(question, Arrays.asList("True", "False"), Collections.singletonList(correctAnswer.toString()));
    }

    @Override
    public String getFullQuestion() {
        return getPossibleChoices().get(0)+ " or " +getPossibleChoices().get(1)+ ": " +this.getQuestion();
    }

    @Override
    public double totalCredit(String guess) {
        guess = guess.trim().equals("1") ? getPossibleChoices().get(0) : guess.trim().equals("2") ? getPossibleChoices().get(2) : guess;
        return this.getLowerCaseCorrectAnswer().contains(guess.trim().toLowerCase()) ? 1 : 0;
    }

}
