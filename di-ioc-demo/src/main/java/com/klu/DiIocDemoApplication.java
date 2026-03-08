package com.klu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.klu.model.student;

@SpringBootApplication
public class DiIocDemoApplication implements CommandLineRunner {

    private final ApplicationContext context;

    public DiIocDemoApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(DiIocDemoApplication.class, args);
    }

    @Override
    public void run(String[] args) {
        student student = context.getBean(student.class);
        student.display();
    }
}
