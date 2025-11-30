package org._13_LoadAndFind.jarviswuod.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        Laptop laptop;
        laptop = session.getReference(Laptop.class, 14); // Proxy
        System.out.println("Laptop: " + laptop);

        // laptop = session.find(Laptop.class, 14);
        // System.out.println("Laptop: " + laptop);

        session.getTransaction().commit();
        session.close();
    }
}
