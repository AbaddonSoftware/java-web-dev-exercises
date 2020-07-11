package org.launch.java.studios.quiz;

import java.util.List;

public class MultipleChoiceQuestion extends Question{

    public MultipleChoiceQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        StringBuilder possibleAnswers = new StringBuilder();
        int answerIndex = 1;
        for (String answer : this.getPossibleChoices()) {
            String fullAnswer =  answerIndex+ ": " +answer+ "\n";
            possibleAnswers.append(fullAnswer);
            answerIndex++;
        }
        return "Pick one:\n" +question+ "\n" + possibleAnswers.toString();
    }

    @Override
    public double totalCredit(String guess) {
        int choiceNumber = Integer.parseInt(guess);
        return this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1)) ? 1 : 0;
    }

    @Override
    public String getAnswerResult(String guess) {
        return totalCredit(guess) == 1 ? "This is the correct answer!" : "This was an incorrect answer...";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        boolean isBound = isBoundInput(guess, 1, possibleChoices.size());
        if (isBound) {
            return true;
        }
        System.out.println("Input must be a number between 1 and " +possibleChoices.size());
        return false;
    }
}
