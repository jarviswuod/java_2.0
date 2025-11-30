package org._09_HibernateQueryLanguage.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        // Random random = new Random();

        // for (int i = 0; i < 50; i++) {
        //
        // Student student = new Student();
        // student.setRollNo(i + 4);
        // student.setName("Name" + i);
        // student.setMarks(random.nextInt(100));
        // session.persist(student);
        // }

        Student student = session.createQuery("FROM Student WHERE rollNo = 7", Student.class).uniqueResult();
        System.out.println(student);
        System.out.println();

        // List<Student> students = session.createQuery("FROM Student ",
        // Student.class).list();
        List<Student> students = session.createQuery("FROM Student WHERE marks > 50", Student.class).list();

        for (Student stud : students) {
            System.out.println(stud);
        }

        session.getTransaction().commit();
        session.close();

    }
}
