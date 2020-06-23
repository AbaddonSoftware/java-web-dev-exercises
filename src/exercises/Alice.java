package exercises;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Alice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String searchString;
        String aliceInStrings = "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversation?'";
        System.out.println(aliceInStrings);
        System.out.println("Search for a string above: ");
        searchString = input.nextLine();
        boolean doesContain = aliceInStrings.toLowerCase().contains(searchString.toLowerCase());
        System.out.println("\nSearch string was found? " +doesContain+ "\n");
        int currentOccurrence = 1;
        int currentIndex = 0;
        int theLength = searchString.length();
        int totalOccurrences = Collections.frequency(Arrays.asList(aliceInStrings.toLowerCase().split(" ")), searchString.toLowerCase());
        while (doesContain && currentOccurrence <= totalOccurrences) {
            currentIndex = aliceInStrings.toLowerCase().indexOf(searchString.toLowerCase(), currentIndex);
            System.out.println("Instance " + currentOccurrence + " was found at " + currentIndex);
            currentOccurrence++;
            currentIndex += theLength;
        }
            System.out.println("\n" +searchString+ " is " +theLength + " letters long");
            String lookingGlass = aliceInStrings.toLowerCase().replaceAll(searchString.toLowerCase(), "");
            System.out.println("\n" +lookingGlass);
    }

}

