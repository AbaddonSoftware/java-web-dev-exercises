package exercises;
import java.util.Scanner;

public class Alice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String searchString;
        String aliceInStrings = "Alice was beginning to get very tired of sitting by her" +
                " sister on the bank, and of having nothing to do: once or twice she had peeped" +
                " into the book her sister was reading, but it had no pictures or conversations in it," +
                " 'and what is the use of a book,' thought Alice 'without pictures or conversation?'";

        System.out.println(aliceInStrings);
        System.out.println("Search for a string above: ");
        searchString = input.nextLine();
        boolean doesContain = aliceInStrings.toLowerCase().contains(searchString.toLowerCase());
        System.out.println(doesContain);
        if(doesContain) {
            String lookingGlass = aliceInStrings.toLowerCase().replaceAll(searchString.toLowerCase(), "");
            System.out.println(lookingGlass);
        }

    }
}
