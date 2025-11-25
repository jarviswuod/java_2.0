package org._11_HQLPart_3.jarviswuod;

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

//        List<Student> students = session
//                .createNativeQuery("SELECT * FROM Student WHERE marks > 97")
//                .addEntity(Student.class)
//                .list();
//
//        for (Student s : students) {
//            System.out.println(s);
//        }


        List<Object[]> rows = session
                .createNativeQuery(
                        "SELECT name, marks FROM Student WHERE marks > 97"
                )
                .list();

        for (Object[] r : rows) {
            System.out.println(r[0] + " : " + r[1] );
        }


        session.getTransaction().commit();
        session.close();

    }
}
