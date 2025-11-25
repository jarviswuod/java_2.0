package org._05_eagerAndLazyLoading.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {


        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        Student student = session.find(Student.class, 1);
        System.out.println(student.getName());

        System.out.println();

        // List<Laptop> laptops= student.getLaptops();

        // System.out.println("Laptops: "+ laptops);

        session.getTransaction().commit();

        session.close();

    }
}
