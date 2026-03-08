package klu.HQLDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate Query Examples");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // 1. Named Parameter
        Query<Students> q1 = session.createQuery(
                "FROM Students WHERE department = :dept", Students.class);
        q1.setParameter("dept", "CSE");
        List<Students> list1 = q1.getResultList();
        System.out.println("Students from CSE:");
        list1.forEach(s -> System.out.println(s.getName()));

        // 2. Positional Parameter
        Query<Students> q2 = session.createQuery(
        	    "FROM Students WHERE marks > ?1", Students.class);
        	q2.setParameter(1, 70);
        List<Students> list2 = q2.getResultList();
        System.out.println("\nStudents with marks > 70:");
        list2.forEach(s -> System.out.println(s.getName()));

        // 3. Aggregate Function
        Query<Long> q3 = session.createQuery(
                "SELECT count(s.id) FROM Students s", Long.class);
        Long count = q3.getSingleResult();
        System.out.println("\nTotal Students: " + count);

        // 4. Sorting
        Query<Students> q4 = session.createQuery(
                "FROM Students ORDER BY marks DESC", Students.class);
        List<Students> sortedList = q4.getResultList();
        System.out.println("\nStudents Sorted by Marks:");
        sortedList.forEach(s ->
                System.out.println(s.getName() + " - " + s.getMarks()));

        // 5. Pagination
        Query<Students> q5 = session.createQuery("FROM Students", Students.class);
        q5.setFirstResult(0);
        q5.setMaxResults(3);
        List<Students> pageList = q5.getResultList();
        System.out.println("\nFirst 3 Students:");
        pageList.forEach(s -> System.out.println(s.getName()));

        // 6. Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Students> cq = cb.createQuery(Students.class);
        Root<Students> root = cq.from(Students.class);
        cq.select(root).where(cb.gt(root.get("marks"), 80));
        Query<Students> q6 = session.createQuery(cq);
        List<Students> criteriaList = q6.getResultList();
        System.out.println("\nCriteria API - Marks > 80:");
        criteriaList.forEach(s -> System.out.println(s.getName()));

        tx.commit();
        session.close();
        factory.close();
    }
}