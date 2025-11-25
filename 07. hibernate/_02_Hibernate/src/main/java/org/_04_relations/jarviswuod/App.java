package org._04_relations.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {


        Laptop laptop = new Laptop();
        laptop.setName("Macbook Pro");
        laptop.setLaptopId(22);

        Laptop laptop2 = new Laptop();
        laptop2.setName("Apple");
        laptop2.setLaptopId(52);

        Student student = new Student();
        student.setRollNo("221");
        student.setName("A Random");
        student.setMarks(85);
        student.getLaptops().add(laptop);

        laptop.getStudents().add(student);
        laptop2.getStudents().add(student);


        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(student);
        session.persist(laptop);
        session.persist(laptop2);
        session.getTransaction().commit();

        session.close();

    }
}
