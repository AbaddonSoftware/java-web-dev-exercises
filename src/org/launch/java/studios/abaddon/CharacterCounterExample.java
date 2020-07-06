package org.launch.java.studios.abaddon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharacterCounterExample {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String hiddenFigures="If the product of two terms is zero then common sense says at least one of the two terms has to be zero to start with. So if you move all the terms over to one side, you can put the quadratics into a form that can be factored allowing that side of the equation to equal zero. Once you’ve done that, it’s pretty straightforward from there.";
        String line = null;
        StringBuilder stringFromFile = new StringBuilder();
        BufferedReader fileRead = new BufferedReader(new FileReader( "file.txt" ));
        while((line = fileRead.readLine()) != null) {
            stringFromFile.append(line + "\n");
        }
        System.out.println("Type a string to check:");
        String stringFromInput = input.nextLine();
        CharacterCounter internalString = new CharacterCounter(hiddenFigures);
        CharacterCounter inputString = new CharacterCounter(stringFromInput);
        CharacterCounter fileString = new CharacterCounter(stringFromFile.toString());

        System.out.println("\n(THE STRING FROM THE MOVIE: HIDDEN FIGURES)");
        System.out.println(hiddenFigures);
        System.out.println("All the characters");
        System.out.println(internalString.toString());
        System.out.println("All the alphanumeric characters");
        System.out.println(internalString.getString(true));

        System.out.println("\n(THE STRING YOU TYPED IN)");
        System.out.println(stringFromInput);
        System.out.println("All the characters");
        System.out.println(inputString.toString());
        System.out.println("All the alphanumeric characters");
        System.out.println(inputString.getString(true));

        System.out.println("\n(THE STRING CREATED FROM THE FILE)");
        System.out.println(stringFromFile.toString().replaceAll("[\n]$", ""));
        System.out.println("All the characters");
        System.out.println(fileString.toString());
        System.out.println("All the alphanumeric characters");
        System.out.println(fileString.getString(true));
    }

}
