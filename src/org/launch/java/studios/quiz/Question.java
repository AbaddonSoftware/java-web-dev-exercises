package org.launch.java.studios.quiz;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Question {
    String question;
    List<String> possibleChoices;
    List<String> correctAnswer;

    public Question(String question, List<String> possibleChoices, List<String> correctAnswer) {
        this.question = question;
        this.possibleChoices = possibleChoices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPossibleChoices(List<String> possibleChoices) {
        this.possibleChoices = possibleChoices;
    }

    public List<String> getPossibleChoices() {
        return possibleChoices;
    }

    public List<String> getLowerCasePossibleChoices() {
        return possibleChoices.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getLowerCaseCorrectAnswer() {
        return correctAnswer.stream().map(String::toLowerCase).collect(Collectors.toList());
    }



    public void setCorrectAnswer(List<String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public abstract String getFullQuestion();
    public abstract double totalCredit(String guess);
    public abstract String getAnswerResult(String guess);
    public abstract boolean isFormattedAnswer(String guess);

    public void printFullQuestion() {
        System.out.println(getFullQuestion());
    }

    public void printValidateAnswer(String guess) {
        System.out.println(getAnswerResult(guess));
    }

    public static boolean isValidInput(String aString, String aType) {
        switch(aType.toLowerCase()) {
            case "positive number":
                return aString.matches("^[0-9]+$");
            case "short form":
                return aString.matches("^[.]{3,80}$");
            case "paragraph":
                return aString.matches("^[.]{3,500}$");
        }
        return false;
    }

    public static boolean isBoundInput(String aString, int low, int high) {
        int tens = high / 10;
        int ones = high % 10;
        String regexString = high < 10 ? String.format("^[%d-%d]$", low, high) : String.format("^[0-%d]?[%d-9]$|^[%d]{1}[0-%d]$", tens-1, low, tens, ones);
        return aString.matches(regexString);
    }

    public static void main(String[] args) {
        System.out.println(isBoundInput("10", 1, 10));
    }
}