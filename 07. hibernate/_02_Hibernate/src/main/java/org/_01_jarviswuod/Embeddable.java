package org._01_jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Embeddable {
    public static void main(String[] args) {


        AlienName alienName = new AlienName();
        alienName.setFirstName("Jarvis");
        alienName.setMiddleName("Wuod");
        alienName.setLastName("Ochieng");

        Alien jarvis = new Alien();
        jarvis.setAid(21);
        jarvis.setName(alienName);
        jarvis.setColor("Yellow");

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(jarvis);   // instead of save()
        session.getTransaction().commit();

        session.close();

    }
}
