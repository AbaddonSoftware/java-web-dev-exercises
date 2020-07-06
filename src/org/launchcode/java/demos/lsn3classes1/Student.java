package org.launchcode.java.demos.lsn3classes1;

// Start working here with your Student class.
// To instantiate the Student class, add your code to the main in the file, SchoolPractice.

import java.util.Objects;

public class Student {

    private String name;
    private int studentId;
    private int numberOfCredits;
    private double gpa;

    public Student(String name, int studentId, int numberOfCredits, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.numberOfCredits = numberOfCredits;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean validName = name.matches("^[a-zA-Z ]{1,48}$");
        if(validName) {
            this.name = name;
        }
        else {
            System.out.println(name+ " given but Name must only contain letters and spaces and can not be greater than 48 total characters");;
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private int valueFrom(boolean oneOfTwo) {
        return oneOfTwo ? 1 : 0;
    }

    public String getGradeLevel() {
        String[] gradeLevels = {"Freshman", "Sophomore", "Junior", "Senior"};
        int credits = this.getNumberOfCredits();
        int gradeIndex = valueFrom(credits > 30) + valueFrom(credits > 60) + valueFrom(credits > 90);
        return gradeLevels[gradeIndex];
    }

    public void addGrade(int newCredits, double newGrade) {
        double currentQualityScore = this.gpa * this.numberOfCredits;
        currentQualityScore += newCredits * newGrade;
        this.gpa = currentQualityScore / numberOfCredits;
    }

    @Override
    public String toString() {
        return  "'" +name+ '\'' +
                ", a " +getGradeLevel()+
                ", with the studentId:" +studentId+
                " and credits equal to " +numberOfCredits+
                " and a gpa of " +gpa+ ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getStudentId() == student.getStudentId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}