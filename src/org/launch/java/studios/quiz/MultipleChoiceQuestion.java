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
        return this.question + "\n" + possibleAnswers.toString();
    }

    @Override
    public boolean isCorrect(String guess) {
        int choiceNumber = isProperFormat(guess, "positive number") ? Integer.parseInt(guess) : -1;
        boolean isBoundNumber = choiceNumber != -1 && isBound(choiceNumber, 1, this.getPossibleChoices().size());
        return isBoundNumber && this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1));
    }

    @Override
    public String validateAnswer(String guess) {
        return isCorrect(guess) ? "This is the correct answer!" : "This was an incorrect answer...";
    }
}
