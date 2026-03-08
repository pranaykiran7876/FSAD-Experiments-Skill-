package com.klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.klu.service.Course;

@Component
public class student {

    // ===== Primitive Type Dependencies =====
    @Value("101")
    private int id;

    @Value("9876543210")
    private long phone;

    @Value("85.5")
    private float marks;

    @Value("72.45")
    private double percentage;

    @Value("true")
    private boolean active;

    @Value("A")
    private char grade;

    @Value("Rama")
    private String name;

    // ===== Collection Dependency =====
    @Value("#{'Maths,Physics,Computers'.split(',')}")
    private List<String> subjects;

    // ===== Non-Primitive Object Dependency =====
    @Autowired
    private Course course;

    public void display() {
        System.out.println("---- Student Details ----");
        System.out.println("ID          : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Phone       : " + phone);
        System.out.println("Marks       : " + marks);
        System.out.println("Percentage  : " + percentage);
        System.out.println("Active      : " + active);
        System.out.println("Grade       : " + grade);
        System.out.println("Subjects    : " + subjects);
        System.out.println("Course      : " + course.getCourseName());
    }
} 
