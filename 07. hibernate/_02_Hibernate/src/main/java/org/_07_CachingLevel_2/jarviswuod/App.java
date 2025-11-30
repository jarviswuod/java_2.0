package org._07_CachingLevel_2.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Student student;

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        student = session.find(Student.class, 1);

        session.getTransaction().commit();
        session.close();

        // --------------------------------------------------------------------------
        // --------------------------------------------------------------------------
        // --------------------------------------------------------------------------

        Session session2 = sf.openSession();
        session2.beginTransaction();

        student = session2.find(Student.class, 1);
        System.out.println(student);

        session2.getTransaction().commit();
        session2.close();

    }
}
