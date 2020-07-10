package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.List;

public class CheckBoxQuestion extends MultipleChoiceQuestion{
    public CheckBoxQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    @Override
    public boolean isCorrect(String guess) {
        String[] answers = guess.split("[, ]+");
        int totalCorrectAnswers = this.getCorrectAnswer().size();
        int totalCorrectlyAnswered = 0;
        for (String answer : answers) {
            int choiceNumber = isProperFormat(answer, "positive number") ? Integer.parseInt(answer) : -1;
            boolean isBoundNumber = choiceNumber != -1 && isBound(choiceNumber, 1, this.getPossibleChoices().size());
            boolean isCorrect = isBoundNumber && this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1));
            totalCorrectlyAnswered += isCorrect ? 1 : 0;
        }
        return answers.length == totalCorrectAnswers && totalCorrectlyAnswered == totalCorrectAnswers;
    }

    @Override
    public String validateAnswer(String guess) {
        return isCorrect(guess) ? "This is correct" : "This was incorrect.";
    }
}
