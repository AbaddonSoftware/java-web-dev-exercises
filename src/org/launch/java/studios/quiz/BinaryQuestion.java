package org.launch.java.studios.quiz;

import org.launch.java.studios.quiz.customexceptions.NotBinaryException;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class BinaryQuestion extends MultipleChoiceQuestion {

    public BinaryQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) throws NotBinaryException {
        super(question, possibleChoices, correctAnswer);
        if (possibleChoices.size() != 2) { throw new NotBinaryException("notBinaryException: two choices not found."); }
    }

    public BinaryQuestion(String question, Boolean correctAnswer) {
        super(question, Arrays.asList("True", "False"), Collections.singletonList(correctAnswer.toString()));
    }

    @Override
    public String getFullQuestion() {
        return getPossibleChoices().get(0)+ " or " +getPossibleChoices().get(1)+ ": " +this.getQuestion();
    }

    @Override
    public double totalCredit(String formattedGuess) {
        formattedGuess = formattedGuess.equals("1") ? possibleChoices.get(0) : formattedGuess.equals("2") ? possibleChoices.get(1) : formattedGuess;
        return this.getLowerCaseCorrectAnswer().contains(formattedGuess.toLowerCase()) ? 1 : 0;
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        String word1 = possibleChoices.get(0).toLowerCase();
        String word2 = possibleChoices.get(1).toLowerCase();
        int totalAnswers = possibleChoices.size();
        boolean isWordAnswer = guess.equals(word1) || guess.equals(word2);
        boolean isBound = isBoundInput(guess, 1, totalAnswers);
        if (isBound || isWordAnswer) {
            return true;
        }
        System.out.printf("Input must be a number between 1 and %d or the words %s or %s%n", totalAnswers, word1, word2);
        return false;
    }

}
