package exercises;
import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double area;
        double length;
        double width;
        System.out.println("Enter a width of the rectangle: ");
        width = input.nextDouble();
        System.out.println("Enter a length of the rectangle: ");
        length = input.nextDouble();
        input.close();
        area = length * width;
        System.out.println("The area of a rectangle of length " +length+ " and width " +width+ " is " +area);
    }
}
