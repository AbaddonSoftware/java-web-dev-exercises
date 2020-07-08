package org.launch.java.studios.quiz;

import java.util.List;

public class BooleanQuestion extends Question {

    public BooleanQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    @Override
    public String getQuestion() {
        StringBuilder possibleAnswers = new StringBuilder();
        int answerIndex = 1;
        for (String answer : this.getPossibleChoices()) {
         possibleAnswers.append(answerIndex+ ": " +answer + "\n");
         answerIndex++;
        }
        return this.question + "\n" + possibleAnswers.toString();
    }

    @Override
    public List<String> getPossibleChoices() {
        return possibleChoices;
    }

    @Override
    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean isCorrect(String guess) {
        return false;
    }

    @Override
    public String verifyCorrectAnswer(String guess) {
        return null;
    }


}
