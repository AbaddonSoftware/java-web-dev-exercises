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
    public abstract boolean isCorrect(String guess);
    public abstract String validateAnswer(String guess);

    public void printFullQuestion() {
        System.out.println(getFullQuestion());
    }

    public void printValidateAnswer(String guess) {
        System.out.println(validateAnswer(guess));
    }

//    public static boolean isProperFormat(String aString, String type, String errorMsg) {
//        boolean isMatch = false;
//        switch(type.toLowerCase()) {
//            case "positive number":
//                isMatch = aString.matches("^[0-9]*$");
//                break;
//            case "short form":
//                return aString.matches("^[.]{3,80}$");
//            case "paragraph":
//                return aString.matches("^[.]{3,500}$");
//        }
//        if(!isMatch) {
//            System.out.println(errorMsg);
//        }
//        return isMatch;
//    }

    public static boolean isProperFormat(String aString, String type) {
        boolean isMatch = false;
        switch(type.toLowerCase()) {
            case "positive number":
                isMatch = aString.matches("^[0-9]*$");
                break;
            case "short form":
                return aString.matches("^[.]{3,80}$");
            case "paragraph":
                return aString.matches("^[.]{3,500}$");
        }
        return isMatch;
    }

    public static boolean isBound(int anInt, int lowValue, int highValue) {
        return anInt >= lowValue && anInt <= highValue;
    }

}