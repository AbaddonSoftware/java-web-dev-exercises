package exercises;

public class Array {
    public static void main(String[] args) {
        int[] fiblings = {1,1,2,3,5,8};
        String sam = "I would not, could not, in a box. I would not, could not with a fox. I will not eat them in a house. I will not eat them with a mouse.";
System.out.println("\nAll the numbers");
        for (int fib:fiblings) {
            System.out.println(fib);
        }
System.out.println("\nJust the even numbers");
        for (int fib:fiblings) {
            if (fib % 2 == 0) {
                System.out.println(fib);
            }
        }
System.out.println("\nSeparated as words.");
        for (String word : sam.split("[^0-9a-zA-Z']+")) {
            System.out.println(word.trim());
        }
System.out.println("\nSeparated as sentences");
        for (String sentence : sam.split("[\\.]")) {
            System.out.println(sentence.trim() + ". ");
        }



    }
}
