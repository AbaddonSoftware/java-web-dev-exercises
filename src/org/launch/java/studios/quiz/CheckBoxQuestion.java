package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.List;

public class CheckBoxQuestion extends MultipleChoiceQuestion{


    public CheckBoxQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    @Override
    public double totalCredit(String guess) {
        String[] answers = guess.split("[, ]+");
        double totalCorrectAnswers = this.getCorrectAnswer().size();
        double totalCorrectlyAnswered = 0;
        for (String answer : answers) {
            int choiceNumber = isProperFormat(answer, "positive number") ? Integer.parseInt(answer) : -1;
            boolean isBoundNumber = choiceNumber != -1 && isBound(choiceNumber, 1, this.getPossibleChoices().size());
            boolean isCorrect = isBoundNumber && this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1));
            totalCorrectlyAnswered += isCorrect ? 1 : 0;
        }
        double totalIncorrectlyAnswered = answers.length - totalCorrectlyAnswered;
        //hack for now, will fix later
        return answers.length < this.getLowerCasePossibleChoices().size() ? (totalCorrectlyAnswered - totalIncorrectlyAnswered) / totalCorrectAnswers : 0;
    }

    @Override
    public String validateAnswer(String guess) {
        return totalCredit(guess) == 1 ? "This is correct." : totalCredit(guess) > 0 ? "Partially correct." : "This was incorrect.";
    }
}
