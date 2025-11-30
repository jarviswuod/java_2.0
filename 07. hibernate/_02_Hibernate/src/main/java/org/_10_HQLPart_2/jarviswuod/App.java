package org._10_HQLPart_2.jarviswuod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();

        // Student student = session.createQuery("FROM Student WHERE rollNo = 7",
        // Student.class).uniqueResult();
        // Object[] student = (Object[]) session.createQuery("SELECT rollNo, name, marks
        // FROM Student WHERE rollNo = 7").uniqueResult();
        //
        // for (Object o : student) {
        // System.out.println(o);
        // }
        // System.out.println();

        // List<Object[]> students = (List<Object[]>) session.createQuery("SELECT
        // rollNo, name, marks FROM Student WHERE marks > 97").list();
        //
        // for (Object[] student : students) {
        // System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
        // }
        // System.out.println();
        // List<Object[]> students = (List<Object[]>) session.createQuery("SELECT
        // rollNo, name, marks FROM Student stud WHERE stud.marks > 97").list();
        //
        // for (Object[] student : students) {
        // System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
        // }

        // System.out.println();
        // Long marks = (Long) session.createQuery("SELECT sum(marks) FROM Student stud
        // WHERE stud.marks > 50").uniqueResult();
        //
        // System.out.println(marks);

        Student student = session.createQuery("FROM Student WHERE rollNo = :rollNo", Student.class)
                .setParameter("rollNo", 1)
                .uniqueResult();
        System.out.println(student);
        System.out.println();

        session.getTransaction().commit();
        session.close();

    }
}
