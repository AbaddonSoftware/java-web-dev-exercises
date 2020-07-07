package org.launch.java.studios.quiz;

import java.util.List;

public abstract class Question {
    public abstract String getQuestion();
    public abstract List<String> getPossibleAnswers();
    public abstract Boolean verifyCorrectAnswer();
}
