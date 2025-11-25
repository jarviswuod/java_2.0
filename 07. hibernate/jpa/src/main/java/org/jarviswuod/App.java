package org.jarviswuod;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Techy tech = new Techy();
        tech = em.find(Techy.class, 5);

        System.out.println(tech);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
