package _01_Intro;

/*

    Notes:
    - Hibernate is an ORM tool used for persisting data

    - Java:
        - We have different software written in different programming languages java being among the languages
        - When you make a software, the software will be interacting with data, the data can be a normal variable or can be an object. Variables can be int, double, float while Objects will be Student object or Employer object where every object is having some data with it. Example:
                class Student {
                    rollno,
                    name,
                    marks
                }

        - In this case when you create an object of Student it will be having the 3 variables, that makes one object. We want to store this object with all it's data for persistance, this is where database comes into play


    - Database:
        - Database can anywhere between MySQL, Oracle, Sql Server
        - We use the db so that we can store data and that concept of storing data is called persistance. Variables are transient(temporary) meaning we dont store varaibles inside the db directly
        - TO be able to connect your database with Java our programming language, we use a concept of Java Database Connectivity (JDBC)

    - Java Database Connectivity (JDBC):
        - The moment you connect your database with java via JDBC we need to use an SQL language
        - Devs wanted a solution where you can store data into the db without the use SQL query language
        - The second concern is that once you have an object say a Student object from the example provided earlier. If you want to store this data into the db

            new Student(101, "Jarvis", 87);

        - To work with SQL that will enable you save the data, you have to write an SQL query using the seven steps of JDBC after which teh query will say "insert into Student ..."
        - A solution to this in java there is a possibility to store the object directly into the db by just calling a save() method. This aspect and possiblity is al provided by Object Relational Mapping (ORM)


    - Object Relational Mapping (ORM):
        - You can convert an object into rows and column in the db by the help of ORM
        - Quick breakdown is our Student class is the same as a table structure in a db with rollno being our first row, second column being our name and third column being marks
        - Objects made from the Student class will become our table rows meaning if you have 5 objects it means you have 5 rows in our db Student table
        - In summary one class is one table while your objects is your rows. This means we are trying to make a relationship between OOP concepts and relational database system, the possibility is provided by ORM
            - O ->  OOP Objects
            - R ->  Relational DB
            - M ->  Mapping objects with relational db

        - ORM is just a concept and to implement it you need an ORM tool


    - Hibernate: ORM tool;
        - One of ORM tools is hibernate, but not the only one, we also have iBatis and toplink too
        - Using hibernate you can store our objects into the db directly with he help of save() method
        - To use the save() method, we need to create an object of Session
        - To create a Session object we need to create a SessionFactory Object first
        - In SessionFactory you need to provide your db configuration details like in JDBC. We can use either XML way of configuration or use java configuration way
            - You have to provide your Driver name, your db URL, your username and password inside your XML for it to be loaded by SessionFactory object

*/

public class _02_HibernateTheory {

}
