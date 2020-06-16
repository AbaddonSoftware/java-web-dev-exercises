package org.launch.java.studios.areaofacircle;
import java.util.Scanner;
public class Area {
    public static void main(String[] args) {
        Scanner input;
        double radius;
        double area;
        input = new Scanner(System.in);
        System.out.println("Enter a radius: ");
        radius = input.nextDouble();
        input.close();
        area = Circle.getArea(radius);
        System.out.println("The area of a circle of radius " + radius + " is: " + area );
    }
}
