package org.launch.java.studios.countingcharacters;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountCharacters {
    public static HashMap<Character, Integer> count(String aString) {
        HashMap<Character, Integer> characterMap = new HashMap<>();
        while (aString.length() != 0) {
            char character = aString.charAt(0);
            characterMap.put(character, (int)aString.chars().filter(ch -> ch == character).count());
            aString = aString.replaceAll("[" +character+ "]", "");
        }
        return characterMap;
    }

    public static HashMap<Character, Integer> count(String aString, Boolean alphaNumericOnly){
        aString = alphaNumericOnly ? aString.toLowerCase().replaceAll("[^A-Za-z0-9]", "") : aString;
        HashMap<Character, Integer> characterMap = new HashMap<>();
        while (aString.length() != 0) {
            char character = aString.charAt(0);
            characterMap.put(character, (int)aString.chars().filter(ch -> ch == character).count());
            aString = aString.replaceAll("[" +character+ "]", "");
        }
        return characterMap;
    }

    public static void print(HashMap<Character, Integer> aHashMap) {
        aHashMap.entrySet().forEach(
                element->{ System.out.print("\"" +element.getKey()+ "\"" + "-" + element.getValue() + " "); });
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String hiddenFigures="If the product of two terms is zero then common sense says at least one of the two terms has to be zero to start with. So if you move all the terms over to one side, you can put the quadratics into a form that can be factored allowing that side of the equation to equal zero. Once you’ve done that, it’s pretty straightforward from there.";
        System.out.println(hiddenFigures);

        System.out.println("All characters in string");
        print(count(hiddenFigures));

        System.out.println("All alphanumeric characters in string");
        print(count(hiddenFigures, true));

        System.out.println("Enter a string to print");
        String userString = input.nextLine();

        System.out.println("All characters");
        print(count(userString));

        System.out.println("All alphanumeric characters");
        print(count(userString, true));

        BufferedReader fileRead = new BufferedReader(new FileReader( "file.txt" ));
        String finalString ="", line;
        while((line = fileRead.readLine()) != null) {
            finalString += line + "\n";
        }
        System.out.println("String from file");
        System.out.println(finalString);
        System.out.println("From File: file.txt counting all characters");
        print(count(finalString));

        System.out.println("From File: file.txt counting only alphanumeric characters");
        print(count(finalString, true));
    }
}
