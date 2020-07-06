package org.launchcode.java.demos.lsn3classes1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SchoolPractice {
    public static void main(String[] args) {
        String[] studentNames = {"Corwin", "Trevor", "Greg", "Brenden", "Donnie"};
        List<Student> classStudents = new ArrayList<>();
        Teacher currentInstructor = new Teacher("Paul", "Carrao", "Java", 4);
        int id = 0;
        Random rand = new Random();
        for (String name : studentNames) {
            int currentCredits = 20 + rand.nextInt(101);
            Student newStudent = new Student(name, id, currentCredits, 4.0);
            classStudents.add(newStudent);
            id++;
        }
        Course launchCodeJava =
                new Course(currentInstructor, "Java", "It ain't groovy but where would groovy be without it?", classStudents, true );
        System.out.println(launchCodeJava.toString());

    }
}
