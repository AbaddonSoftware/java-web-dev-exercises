package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.List;

public class CheckBoxQuestion extends MultipleChoiceQuestion{

    public CheckBoxQuestion(String question, List<String> possibleChoices, List<String> correctAnswer) {
        super(question, possibleChoices, correctAnswer);
    }

    @Override
    public String getFullQuestion() {
        return "May be more than one correct answer:\n" +super.getFullQuestion().substring(10)    // This is a bad hack "Pick one:\n" = 0-10
                + "\nAnswers may be either space and/or comma separated.";
    }



    @Override
    public double totalCredit(String formattedGuess) {
        String[] inputs = formattedGuess.split("[, ]+");
        double totalInputs = inputs.length;
        double totalCorrectAnswers = correctAnswer.size();
        double totalCorrectlyAnswered = 0;
        for (String input : inputs) {
            int choiceNumber = Integer.parseInt(input);
            boolean isCorrect = this.getLowerCaseCorrectAnswer().contains(this.getLowerCasePossibleChoices().get(choiceNumber - 1));
            totalCorrectlyAnswered += isCorrect ? 1 : 0;
        }
        double totalIncorrectlyAnswered = totalInputs - totalCorrectlyAnswered;
        double result = totalCorrectlyAnswered - totalIncorrectlyAnswered > 0 ? (totalCorrectlyAnswered - totalIncorrectlyAnswered) / totalCorrectAnswers : 0;
        return result;
    }

    @Override
    public String getAnswerResult(String formattedGuess) {
        double totalCredit = totalCredit(formattedGuess);
        String percentScore = String.format("%.0f%%", totalCredit * 100);
        return totalCredit == 1 ? "This is correct. " +percentScore : totalCredit > 0 ? "Partially correct. " +percentScore : "This was incorrect. " +percentScore;
    }

    @Override
    public boolean isFormattedAnswer(String guess) {
        String[] inputs = guess.split("[, ]+");
        int totalAnswers = possibleChoices.size();
        int totalInputs = inputs.length;
        int totalBoundInputs = (int) Arrays.stream(inputs).filter(answer -> isBoundInput(answer, 1, totalAnswers)).count();
        boolean unboundInputsFound = totalInputs != totalBoundInputs;
        boolean duplicateInputsFound = Arrays.stream(inputs).distinct().count() != totalInputs;
        boolean inputsMatchOrExceedTotalAnswers = totalInputs >= totalAnswers;
        if(!duplicateInputsFound && !unboundInputsFound ) {// && !inputsMatchOrExceedTotalAnswers) {
            return true;
        }
        System.out.printf("Input must consist of numbers between %d - %d (space or comma separated) and can not meet or exceed total number of possible choices %d.%n", 1, totalAnswers, totalAnswers);
        return false;
    }
}
