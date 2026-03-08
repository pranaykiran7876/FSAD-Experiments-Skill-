package klu.hibernate_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        // ----- Insert -----
        Transaction tx = session.beginTransaction();
        Students student = new Students();
        student.setMarks(133);
        student.setName("chakri");
        session.save(student);   // ID auto-generated if @GeneratedValue is used
        tx.commit();

        // ----- Display -----
        Students student1 = session.find(Students.class, student.getId());
        System.out.println("Data retrieved: " + student1.getMarks());

        // ----- Update -----
        Transaction tx1 = session.beginTransaction();
        student1.setMarks(101);   // Hibernate tracks changes automatically
        tx1.commit();             // No need to call save()

        // ----- Delete -----
//        Transaction tx2 = session.beginTransaction();
//        Students student3 = session.find(Students.class, student.getId());
//        session.delete(student3);
//        tx2.commit();

        session.close();
        factory.close();
    }
}
