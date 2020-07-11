package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.Collections;

public class QuizRunner {
    public static void main(String[] args) {
        Question myTF = new BinaryQuestion("Water is wet?", true);

        Question aMultipleChoice = new MultipleChoiceQuestion("The default value of a static integer variable of a class in Java is? ",
                                                               Arrays.asList("0", "1", "Garbage Value", "Null", "-1"),
                                                               Collections.singletonList("0"));

        Question aCheckBox = new CheckBoxQuestion("What are the 4 principles of Object-oriented programming",
                                                  Arrays.asList("Encapsulation", "Abstraction", "Emulation", "if statements", "Inheritance", "Polymorphism"),
                                                  Arrays.asList("Encapsulation", "Abstraction", "Inheritance", "Polymorphism"));
        Question paragraph = new ParagraphQuestion("Write a 300 character paragraph about Donnie's Disdain for if statements",
                Collections.singletonList("He thinks they are largely overused in modern programming and finds " +
                        "that most of the time this results in code that is unoptimized and hard to read. " +
                        "If he understood how truly valuable they are then he'd probably change his mind " +
                        "else he will continue to fight this battle."));
        Question linearQuestion = new LinearScale("on a scale of 1 to 5: how much does Donnie hate improperly named variables... even when they are all throughout his own code",
                                                   5, "5");

        Quiz myQuiz = new Quiz("The Super Quiz", Arrays.asList(myTF, aMultipleChoice, aCheckBox, paragraph, linearQuestion));




        myQuiz.runQuiz();
    }
}
