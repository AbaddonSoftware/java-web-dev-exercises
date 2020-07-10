package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.Collections;

public class QuizRunner {
    public static void main(String[] args) {
        Question myTF = new BooleanQuestion("Water is wet?", true);

        Question aMultipleChoice = new MultipleChoiceQuestion("The default value of a static integer variable of a class in Java is? ",
                                                               Arrays.asList("0", "1", "Garbage Value", "Null", "-1"),
                                                               Collections.singletonList("0"));

        Question aCheckBox = new CheckBoxQuestion("What are the 4 principles of Object-oriented programming",
                                                  Arrays.asList("Encapsulation", "Abstraction", "Emulation", "if statements", "Inheritance", "Polymorphism"),
                                                  Arrays.asList("Encapsulation", "Abstraction", "Inheritance", "Polymorphism"));

        Quiz myQuiz = new Quiz("The Super Quiz", Arrays.asList(myTF, aMultipleChoice, aCheckBox));
        myQuiz.runQuiz();
    }
}
