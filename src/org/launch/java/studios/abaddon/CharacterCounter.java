package org.launch.java.studios.abaddon;
import java.util.HashMap;

public class CharacterCounter {

    private String aString = null;
    public CharacterCounter (String aString) {
        this.aString = aString;
    }

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> aHashMap = count(this.aString);
        aHashMap.forEach((key, value) -> stringBuilder.append("\"" + key + "\"" + "-" + value + " "));
        return stringBuilder.toString();
    }


    public String getString(Boolean alphanumeric) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> aHashMap = count(this.aString, alphanumeric);
        aHashMap.forEach((key, value) -> stringBuilder.append("\"" + key + "\"" + "-" + value + " "));
        return stringBuilder.toString();
    }

}
