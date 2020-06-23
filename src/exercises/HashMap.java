package exercises;

import java.util.Map;
import java.util.Scanner;

public class HashMap {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> students = new java.util.HashMap<>();
        Scanner input = new Scanner(System.in);
        String newStudent;
        int newId;
        System.out.println("Enter your students (or ENTER to finish):");

        do {
            System.out.println("Student: ");
            newStudent = input.nextLine();
            if (!newStudent.equals("")) {
                newId = newStudent.hashCode();
                students.put(newId, newStudent);
            }

        } while(!newStudent.equals(""));
        System.out.println("\nClass roster:");
        for (Map.Entry<Integer, String> student : students.entrySet()) {
            System.out.println(student.getKey() + " (" + student.getValue() + ")");
        }
    }


}
