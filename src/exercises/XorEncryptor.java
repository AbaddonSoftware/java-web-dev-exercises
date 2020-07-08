package exercises;

import org.launch.java.studios.abaddon.CharacterCounter;

import java.util.Arrays;
import java.util.List;

public class XorEncryptor {
    public static char xorCharacter(char character1, char character2) {
        return (char)(((int)character1) ^ ((int)character2) % 26 );
    }

    public static String xorEncrypt(String text, String key) {
        StringBuilder encodedText = new StringBuilder();
        if (key.equals("")) {
            key = null;
        }
        int index = 0;
        assert key != null;
        char[] keyArray = key.toCharArray();
        for (char ch : text.toCharArray()) {
            char newKey = keyArray[index % key.length()];
            char xoredCharacter = xorCharacter(ch, newKey);
            encodedText.append(Character.isWhitespace(ch) ? ch : xoredCharacter);
            index++;
        }
        return encodedText.toString();
    }

    public static void main(String[] args) {
        String testString = xorEncrypt("This is a test!!1234567890!@#$%^&*()", "test!!");
        System.out.println(testString);
        System.out.println(xorEncrypt(testString, "test!!"));
    }
}
