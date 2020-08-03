package org.launch.java.studios.quiz;

import org.launch.java.studios.quiz.customexceptions.NotBinaryException;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class BinaryQuestion extends MultipleChoiceQuestion {

    public BinaryQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) throws NotBinaryException {
        super(question, possibleChoices, correctAnswer);
        if (possibleChoices.size() != 2) {
            throw new NotBinaryException("NotBinaryException: Must not contain more than 2 elements.");
        }
    }

    public BinaryQuestion(String question, Boolean correctAnswer) {
        super(question, Arrays.asList("True", "False"), Collections.singletonList(correctAnswer.toString()));
    }

    @Override
    public void setPossibleChoices(List<String> possibleChoices) throws NotBinaryException {
        if (possibleChoices.size() != 2) {
            throw new NotBinaryException("NotBinaryException: Must not contain more than 2 elements.");
        }
        this.possibleChoices = possibleChoices;
    }

    @Override
    public String getFullQuestion() {
        String word1 = getPossibleChoices().get(0);
        String word2 = getPossibleChoices().get(1);
        return word1+ " or " +word2+ ": " +this.getQuestion() + "\nAnswers may be either 1 (first option) or 2 (second option) or the words, " +word1+ " or " +word2+ ".";
    }

    @Override
    public double totalCredit(String formattedGuess) {
        formattedGuess = formattedGuess.equals("1") ? possibleChoices.get(0) : formattedGuess.equals("2") ? possibleChoices.get(1) : formattedGuess;
        return this.getLowerCaseCorrectAnswer().contains(formattedGuess.toLowerCase()) ? 1 : 0;
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        String word1 = possibleChoices.get(0);
        String word2 = possibleChoices.get(1);
        boolean isWordAnswer = guess.equals(word1.toLowerCase()) || guess.equals(word2.toLowerCase());
        boolean isBound = isBoundInput(guess, 1, 2);
        if (isBound || isWordAnswer) {
            return true;
        }
        System.out.printf("Input must be a number either 1 (first option) or 2 (second option) or the words, %s or %s%n", word1, word2);
        return false;
    }

}
