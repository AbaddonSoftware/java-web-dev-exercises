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
        double totalAnswers = possibleChoices.size();
        double totalCorrectAnswers = correctAnswer.size();
        double totalCorrectlyAnswered = 0;
        for (String answer : answers) {
            int choiceNumber = Integer.parseInt(answer);
            boolean isCorrect = this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1));
            totalCorrectlyAnswered += isCorrect ? 1 : 0;
        }
        //hack for now, will fix later
        return totalCorrectlyAnswered / totalCorrectAnswers;
    }

    @Override
    public String getAnswerResult(String guess) {
        double totalCredit = totalCredit(guess);
        return totalCredit == 1 ? "This is correct." : totalCredit > 0 ? "Partially correct." : "This was incorrect.";
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        String[] inputs = guess.split("[, ]+");
        int totalAnswers = possibleChoices.size();
        int totalInputs = inputs.length;
        int totalBoundInputs = (int) Arrays.stream(inputs).filter(answer -> isBoundInput(answer, 1, totalAnswers)).count();
        boolean unboundInputsFound = totalInputs != totalBoundInputs;
        boolean duplicateInputsFound = Arrays.stream(inputs).distinct().count() != totalInputs;
        boolean inputsMatchOrExceedAnswers = totalInputs >= totalAnswers;
        if(!duplicateInputsFound && !unboundInputsFound && !inputsMatchOrExceedAnswers) {
            return true;
        }
        System.out.printf("Input must consist of numbers between %d - %d (space or comma separated) and can not meet or exceed total number of possible choices %d.%n", 1, totalAnswers, totalAnswers);
        return false;
    }
}
