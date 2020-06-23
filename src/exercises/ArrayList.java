package exercises;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        java.util.ArrayList<Integer> testNumbers = new java.util.ArrayList<>(Arrays.asList(1,2,3,4,5,6,8,10,6));
        java.util.ArrayList<String> testString = new java.util.ArrayList<>(Arrays.asList("I", "can't", "go", "back", "to", "yesterday", "because", "I", "was", "a", "different", "person", "then"));
        String sam = "I would not, could not, in a box. I would not, could not with a fox. I will not eat them in a house. I will not eat them with a mouse.";
        System.out.println("sum of all even numbers in ArrayList " +testNumbers+ " = " +sumOfEven(testNumbers));
        System.out.println("all words in ArrayList " +testString+ " of string length 5 = " +wordsInListByLength(testString));
        System.out.println("Enter a size of string to search for in ArrayList");
        int desiredStringLength = input.nextInt();
        System.out.println("all words in ArrayList " +testString+ " of string length " +desiredStringLength+ " = " +wordsInListByLength(testString, desiredStringLength));
        java.util.ArrayList<String> samList = new java.util.ArrayList<>(List.of(sam.split("[^0-9a-zA-Z']+")));
        System.out.println("all words in ArrayList " +samList+ " of string length " +desiredStringLength+ " = " +wordsInListByLength(samList, desiredStringLength));
    }

    public static int sumOfEven(java.util.ArrayList<Integer> aList) {
        int sum = 0;
        for (int number : aList) {
            sum += number % 2 == 0 ? number : 0;
        }
        return sum;
    }

    public static int wordsInListByLength(java.util.ArrayList<String> aList, int length) {
        int sum = 0;
        for(String element : aList) {
            sum += Boolean.compare(element.length() == length, false);
        }
        return sum;
    }

    public static int wordsInListByLength(java.util.ArrayList<String> aList) {
        int sum = 0;
        for(String element : aList) {
            sum += Boolean.compare(element.length() == 5, false);
        }
        return sum;
    }
}
