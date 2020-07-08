package org.launch.java.studios.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Question myTF = new BooleanQuestion("Should grader be in Quiz or Questions", Arrays.asList("Quiz", "Questions"), Arrays.asList("Quiz") );

        System.out.println(myTF.getQuestion());
        System.out.println("\nEnter Your Answer: ");
        String answer = input.nextLine();
        System.out.println(myTF.isCorrect(answer));



    }
}
