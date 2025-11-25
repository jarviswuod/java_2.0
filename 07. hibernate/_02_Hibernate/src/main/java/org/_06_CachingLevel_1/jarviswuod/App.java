package org._06_CachingLevel_1.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {

        Student student;

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        // student = session.find(Student.class, 2);
        student = session.find(Student.class, 1);
        student = session.find(Student.class, 1);
        System.out.println(student);


        session.getTransaction().commit();
        session.close();

    }
}
