package org._01_jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {


        AlienName alienName = new AlienName();
        alienName.setFirstName("Jarvo");
        alienName.setMiddleName("Dommy");
        alienName.setLastName("Kakise");

        Alien jarvis = new Alien();
        jarvis.setAid(22);
        jarvis.setName(alienName);
        jarvis.setColor("Orange");

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(jarvis);   // instead of save()
        session.getTransaction().commit();

        session.close();

    }
}
