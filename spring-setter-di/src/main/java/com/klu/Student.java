package com.klu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

    // Primitive types
    private int id;
    private double fee;
    private boolean active;

    // Wrapper classes
    private Integer age;
    private Double marks;

    // String
    private String name;

    // Array
    private String[] skills;

    // Collections
    private List<String> subjects;
    private Set<String> hobbies;
    private Map<String, Integer> semesterMarks;

    // Non-primitive
    private Course course;

    //Default constructor (MANDATORY for Setter DI)
    public Student() {
        System.out.println("Student object created");
    }

    //Setter methods (Injection happens here)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setSemesterMarks(Map<String, Integer> semesterMarks) {
        this.semesterMarks = semesterMarks;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void display() {
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Fee       : " + fee);
        System.out.println("Active    : " + active);
        System.out.println("Age       : " + age);
        System.out.println("Marks     : " + marks);

        System.out.println("Skills:");
        for (String s : skills) {
            System.out.println(" - " + s);
        }

        System.out.println("Subjects  : " + subjects);
        System.out.println("Hobbies   : " + hobbies);
        System.out.println("Semester Marks: " + semesterMarks);

        System.out.println("Course    : " +
                course.getCourseName() + " (" + course.getDuration() + " months)");
    }
}
