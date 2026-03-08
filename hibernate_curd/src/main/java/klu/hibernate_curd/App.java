package klu.hibernate_curd;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= STUDENT CRUD MENU =========");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1: // CREATE
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter City: ");
                    String address = sc.nextLine();

                    Student s = new Student(name, address);
                    dao.saveStudent(s);

                    System.out.println("Student added successfully. ID = " + s.getId());
                    break;

                case 2: // READ by ID
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    Student st = dao.getStudent(id);
                    if (st != null) {
                        System.out.println("ID: " + st.getId());
                        System.out.println("Name: " + st.getName());
                        System.out.println("City: " + st.getAddress());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3: // READ ALL
                    List<Student> list = dao.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nID\tNAME\tCITY");
                        System.out.println("-----------------------");
                        for (Student stu : list) {
                            System.out.println(
                                stu.getId() + "\t" +
                                stu.getName() + "\t" +
                                stu.getAddress()
                            );
                        }
                    }
                    break;

                case 4: // UPDATE
                    System.out.print("Enter Student ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Student us = dao.getStudent(uid);
                    if (us != null) {
                        System.out.print("Enter New address: ");
                        String newAddress = sc.nextLine();

                        us.setAddress(newAddress);
                        dao.updateStudent(us);

                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5: // DELETE
                    System.out.print("Enter Student ID to Delete: ");
                    int did = sc.nextInt();

                    boolean deleted = dao.deleteStudent(did);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
        HibernateUtil.getFactory().close();
    }
}