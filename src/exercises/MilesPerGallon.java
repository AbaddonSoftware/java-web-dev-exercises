package exercises;
import java.util.Scanner;
public class MilesPerGallon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double miles;
        double gallons;
        double milesPerGallon;
        System.out.println("Enter the miles traveled: ");
        miles = input.nextDouble();
        System.out.println("Enter the gallons of utilized: ");
        gallons = input.nextDouble();
        if(gallons != 0) {
            milesPerGallon = miles / gallons;
            System.out.println("MPG = " + milesPerGallon);
        }
        else {
            System.out.println("Division by Zero is not allowed.");
        }

    }
}
