package org.launch.java.studios.areaofacircle;
import org.launch.java.studios.areaofacircle.helper.Helper;
import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner input;
        String radius;
        double area;
        input = new Scanner(System.in);
        do {
            System.out.println("Enter a radius: ");
            radius = input.nextLine();
        } while(!Helper.validateInput(radius, "POSITIVENUMBER", "You must enter a positive number!"));
        input.close();
        area = Circle.getArea(Double.parseDouble(radius));
        System.out.println("The area of a circle of radius " + radius + " is: " + area );
    }


}
