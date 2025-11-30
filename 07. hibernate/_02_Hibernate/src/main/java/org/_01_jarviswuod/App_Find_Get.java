package org._01_jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Find_Get {
    public static void main(String[] args) {

        Alien jarvis = new Alien();

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        jarvis = session.find(Alien.class, 20);

        System.out.println(jarvis);
        session.getTransaction().commit();

        session.close();

    }
}
