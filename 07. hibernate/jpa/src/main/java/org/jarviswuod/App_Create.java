package org.jarviswuod;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App_Create {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Techy tech = new Techy();
        tech.setId(2);
        tech.setName("Woody");
        tech.setTech("Django");

        em.persist(tech);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
