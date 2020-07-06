package org.launchcode.java.demos.lsn3classes1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private Teacher teacher;
    private String subject;
    private String courseDescription;
    private List<Student> students = new ArrayList<>();
    private boolean isOnline;

    public Course(Teacher teacher, String subject, String courseDescription, List<Student> students, boolean isOnline) {
        this.teacher = teacher;
        this.subject = subject;
        this.courseDescription = courseDescription;
        this.students = students;
        this.isOnline = isOnline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public String toString() {
        String isOnline = this.isOnline ? "online " : "";
        StringBuilder theStudents = new StringBuilder();
        for(Student student : students) {
            theStudents.append(student.toString() + " ");
        }
        return "This is the " +isOnline+ "class " +subject+ " with the teacher " +teacher.getFullName()+
                " which has been described as " +courseDescription.toLowerCase()+ " and has " +theStudents+ "currently enrolled.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return isOnline() == course.isOnline() &&
                getTeacher().equals(course.getTeacher()) &&
                getSubject().equals(course.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeacher(), getSubject(), isOnline());
    }
}
