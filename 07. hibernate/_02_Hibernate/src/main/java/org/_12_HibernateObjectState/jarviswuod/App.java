package org._12_HibernateObjectState.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Random;


public class App {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();


        Laptop laptop = new Laptop();
        laptop.setLaptopId(14);
        laptop.setBrand("Dell");
        laptop.setPrice(50000);


        session.persist(laptop);
        laptop.setPrice(80000);

        session.remove(laptop);

        session.getTransaction().commit();

        session.detach(laptop);
        laptop.setPrice(54000);

        session.close();
    }
}
