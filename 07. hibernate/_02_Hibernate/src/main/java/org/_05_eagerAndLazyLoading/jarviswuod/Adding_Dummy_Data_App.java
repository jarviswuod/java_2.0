package org._05_eagerAndLazyLoading.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Adding_Dummy_Data_App {
    public static void main(String[] args) {


        Laptop laptop = new Laptop();
        laptop.setLaptopId(4);
        laptop.setBrand("HP");
        laptop.setPrice(2200);

        Laptop laptop2 = new Laptop();
        laptop2.setLaptopId(5);
        laptop2.setBrand("Asus");
        laptop2.setPrice(1800);

        Laptop laptop3 = new Laptop();
        laptop3.setLaptopId(6);
        laptop3.setBrand("Dell");
        laptop3.setPrice(3000);

        Student student = new Student();
        student.setRollNo(2);
        student.setName("Becky");
        student.setMarks(85);

        Student student1 = new Student();
        student1.setRollNo(3);
        student1.setName("Rebecca");
        student1.setMarks(85);

        laptop.setStudent(student1);
        laptop2.setStudent(student);
        laptop3.setStudent(student1);

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.persist(student);
        session.persist(student1);

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(laptop3);
        session.getTransaction().commit();

        session.close();

    }
}
