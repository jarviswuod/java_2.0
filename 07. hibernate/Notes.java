/*

    NOTES:

    - Hibernate Full course Intro Video:

        - Important concepts when learnin a new technology
            - Why
            - what
            - IMplementation
            - Advanced concepts


        - Hibernate is an ORM(Object Relational Mapping) framework for Java

        - Conncector such as JDBC is needed to connect java(programming language with data) to enable fetching, modifying and saving of the data

        - Data -> Tables which has raws and columns
        - Language -> Objects and classes
        - SQL helps with communication between the 3 worlds, I mean you write queries from within your language/framework and the tables in your db gets modified

        - ORM defines tables and data based on te objects and classes you defined in your programming language



    - Prerequisite for Hibernate:
        - Java
        - SQL
        - JDBC (for connectivity btwn Java and SQL)


    - Hibernate Theory:
        - Persistance - concepts of storing data in the DB

        - Java:
            - Variables
            - Objects

        - Database
            - MySQL
            - Oracle
            - Sql Server

        - JDBC (Java Database Connectivity)
            - For connecting java to DB
            - Heavy use of SQL language for java to talk to DB via JDBC

        - ORM
            - Enables storing, retriving and modifying data in the db without the use of SQL query
            - Direct storage of a java object to the DB by just calling the save() method
            - Conversion of an object into a table this is possible because both class and table structures are kind of related
                - Class can and is easily our table and class instances/ objects easily become our rows inside the tables

        - ORM is just a concepts and we can implement it using the Hibernate framework which is one of the ORM tools available
        - We also have IBatis and TopLink  frameworks being other java ORM tools


    - Hibernate Practical:
        - Alien class with id, name and color
        - Alien Object

        - Configuration
        - SessionFactory
        - Session
        - session.save()

    - Hibernate Plugin in Eclipse

    - Hibernate Practical:
        - configurations
        - Annotations
            - Entity -> converting the Class to a table
            - @Id -> Is a primary Key indication

        - Primary Key for every tables you working with
        - ACID properties when creating a table before adding any rows to it
            - Transaction made

    - Hibernate Configuration
        - File name (hibernate.cfg.xml)
            - hibernate.connection.driver_class -> com.mysql.jdbc.Driver
            - hibernate.connection.url -> jdbc:mysql://localhost:3307/jarvis
            - hibernate.connection.password -> root
            - hibernate.dialect -> org.hibernate.dialect.MySQLDialect
            - hbm2ddl.auto -> create/ update
            - show_sql -> true


    - Annotations:
        - @Entity(name="alian_table")
            -> custom table name different from your class name
            -> By default it's @Entity and assigns the same name as class name

            - NOTE:
                - 3 Layers:
                    - Class name
                    - Entity name
                    - Table name

            - @Entity(name="alian_table"):
                - Both Entity and table name are changed to "alian_table"

            - @Entity
            - @Table
                - Only changes the Table name without affecting the Entity name


        - @Column
            - @Column(name="aliend_color")
                -> Changes column name to a custom name

        - @Transient
            - Makes a colum be ignored whenever you save data to the db


    - Fetching Data Using Hibernate:
        Alien jarvis = null;
        jarvis = (Alien) session.get(Alien.class, 102);
        System.out.println(jarvis);

        NOTE:
            get takes in the class name and primary key/ ID of whatever you want to fecth from the DB


    - How to use Embeddable Object:
            @Entity
            public class Alien {
                @Id
                private int aid;
                private AlienName alienName;
                private String color;
            }


            @Embeddable
            public class AlienName {
                private String fname;
                private String mname;
                private String lname;
            }


        - NOTE:
            - If we change @Embeddable to @Entity then just like that we will be creating another table
            - We dont use @Id annotation because that's used in Entity and we are just embedding our AliendName to Alien class not creating an AlienName Entity


    -  Mapping Relations Theory
        - One to One relationship
            -> Annotation
                @OneToOne
                private Laptop laptop

        - One to Many relationship
            -> Annotation
                Student class:
                    @OneToMany(mappedBy="stud")
                    private List<Laptop> laptops;


                Laptop class:
                    @ManyToOne
                    private Student stud;

        - Many to Many relationship
            -> Annotation
                Student class:
                    @ManyToMany(mappedBy="studs")
                    private List<Laptop> laptops;


                Laptop class:
                    @ManyToMany
                    private List<Student> studs;


    - Fecth EAGER and LAZY
        - LAZY loading
            - Happens by default
            - Only loads the value when needed
            - Fires 2 qeuries to the DB


        - EAGER loading:
            - Fires only one huge request and loading everything needed
            - You have to customize this setting inside the relationship declearer
            - Alien class:
                @OneToMany(mappedBy="alien", fetch=FetchType.EAGER)
                private List<Laptop> laps = new ArrayList<>();


    - Hibernate Caching
        - Hibernate has several advantages over JDBC
            1. ORM
            2. Caching
            
        - Caching means storing a data that's accessed multiple times, easy to reach
        - Improves performance of the system

        - Client -> application server -> DB

        - Types:
            - First level cache
                -> Within the same session
                -> By default given by hibernate

            - Second level cache
                -> Unlimited sessions to share the same level data
                -> Needs to be configured as it's provided by a 3rd party package
                    - ehcache
                    - os
                    - swarm

                -> ehcache
                    - Download the package (provides features)
                    - Download hibernate-ehcache (provides intergration of eh and hibernate)


                    - Configure:
                        - pom.xml
                        - hibernate.cfg.xml

                    - Change your entity by adding
                        @Cacheable
                        @Cache



    - Hibernate Caching Level 1
        Main method:
            Session session = sf.openSession();
            session.beginTransaction();

            a = (Alien) session.get(Alien.class, 101);
            System.out.println(a);

            a = (Alien) session.get(Alien.class, 101);
            System.out.println(a);

            session.getTransation().commit();


        - NOTE:
            - The query is only hitting the DB once and the second time you send the reqeust, you'll find it already cached to application
                - [First Request] :: Client -> application server -> DB
                - [Second Request] :: Client -> application server


    - Hibernate Caching Level 2
        Main method:
            Session session1 = sf.openSession();
            session1.beginTransaction();

            a = (Alien) session1.get(Alien.class, 101);
            System.out.println(a);

            session1.getTransation().commit();
            session1.close();



            Session session2 = sf.openSession();
            session2.beginTransaction();

            a = (Alien) session2.get(Alien.class, 101);
            System.out.println(a);

            session2.getTransation().commit();
            session2.close();


        - NOTE:
            - You have to specify that you going for second level cache
            - You have to get a provider for the second level cache
                - Download the dependencies in pom.xml:
                    - ehcache -> from net.sf.ehcache
                    - hibernate-ehcache -> from org.hibernate

                - Set 2 propoerties inside hibernate.cfg.xml to indicate you are using the second level cache:
                    - hibernate.cache.use_second_level_cache -> true
                    - hibernate.cache.region.factory_class -> org.hibernate.cache.ehcache.EhCacheRegionFactory

                - 2 Annotations needed on the entity:
                    - @Cacheable
                    - @Cache(usage=CacheConcurrencyStrategy>READ_ONLY)

                    - This is declared btwn @Entity and public class Alien {...}




    - Hibernate Caching Level 2 with Query(SQL)
        Main method:
            Session session1 = sf.openSession();
            session1.beginTransaction();

            Query q1 = session1.createQuery("from Alien where aid=101");
            q1.setCacheable(true);              // Storing to cache
            a = (Alien) q1.uniqueResult();      // For getting only one row
            System.out.println(a);

            session1.getTransation().commit();
            session1.close();



            Session session2 = sf.openSession();
            session2.beginTransaction();

            Query q2 = session2.createQuery("from Alien where aid=101");
            q2.setCacheable(true);              // Retrieving from cache
            a = (Alien) q2.uniqueResult();      // For getting only one row
            System.out.println(a);

            session2.getTransation().commit();
            session2.close();


        - NOTE:
            - Instead of using the get() method to fetch values, we are using Query
            - We observe same data being queried 2 times because by default second level caching is applicable for get() method and not query
                - One more propoery needed inside hibernate.cfg.xml to enable Query caching
                    - hibernate.cache.use_query_cache -> true

                - Specify also for the query Object
                    q1.setCacheable(true);          // Storing to cache

                    ...
                    q2.setCacheable(true);          // Retrieving from cache




    - Hibernate Query Language (HQL) Theory:
        - Part One:
            Query q =  session.createQuery("from Student");
            List<Student> students = q.list();

            Query q =  session.createQuery("from Student where marks > 50");
            List<Student> students = q.list();
            
            Query q =  session.createQuery("from Student where rollno=7");
            Student student = (Student) q.uniqueResult();


        - Part Two:
            Query q =  session.createQuery("select rollno,name,marks from Student where rollno=7");
            Object[] student = (Object[]) q.uniqueResult();
            System.out.println(student[0] + " : " + student[1] + " : " + student[2]);



            Query q =  session.createQuery("select rollno,name,marks from Student");
            List<Object[]> student = (List<Object[]>) q.list();

            for(Object[student] : students)
                System.out.println(student[0] + " : " + student[1] + " : " + student[2]);



            Query q =  session.createQuery("select rollno,name,marks from Student s where s.marks>60");
            List<Object[]> student = (List<Object[]>) q.list();

            for(Object[student] : students)
                System.out.println(student[0] + " : " + student[1] + " : " + student[2]);



            Query q =  session.createQuery("select sum(marks) from Student s where s.marks>60");
            Long marks = (Long) q.uniqueResult();
            System.out.println(marks);



            int b = 60;
            Query q =  session.createQuery("select sum(marks) from Student s where s.marks > :b");
            q.setParameter("b", b);
            Long marks = (Long) q.uniqueResult();
            System.out.println(marks);

            NOTE::
                - [:] colon is being used as a positional parameter


        - Part Three: Native Queries...
            SQLQuery qeury =  session.createSQLQuery("select * from student where marks>60");
            query.addEntity(Student.class);
            List<Student[]> students = query.list();

            for(Student student : students)
                System.out.println(student);


            SQLQuery qeury =  session.createSQLQuery("select name,marks from student where marks>60");
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List students = query.list();

            for(Object obj : students) {
                Map studObj = (Map) obj;
                System.out.println(obj.get("name") + " : " + obj.get("marks"));
            }



    - Hibernate Object States / Persistence Life Cycle:
        - new  -> garbage

        - Transient
            - save()
            - persist()

        - Persistence:
            - detach()

        - Detached

        - Removed



    - Hibernate Get vs Load:
        - get:
            Laptop laptop =  session.get(Laptop.class, 6);
            System.out.println(laptop);
                - Everytime you use get(), it will hit the DB
                - Give you the object
                - It gives you null when object you want is not in the DB


        - load:
            Laptop laptop =  session.load(Laptop.class, 6);
            System.out.println(laptop);
                - load() does not hit the DB i.e it does not fire the query until you want to use the object
                - Give you the proxy object
                - It throw an ObjectNotFoundException which you can handle


    - What is JPA? JPA Implementation:
        - Java Persistance API - (JPA)
            - Prerequisite:
                - Java
                - RDBMS
                - JDBC
                - Hibernate (Optional)

        - Object Relational Mapping:
            - Connecting java to a DB directly
            - ORM Tools:
                - Hibernate
                - iBatis
                - TopLink

        - JPA is a specification that makes it eay to switch between different ORM tools
        - To work with JPA you do need the ORM tools and one cannot build a JPA solution without any of them



    - JPA implementation:
        - Adding hibernate dependency
        - Adding mysql-connector to work with DB

        - Created a persistace file under:
            src/main/resources/META-INF/persistance.xml
            This file entails configuration to db:
                - javax.persistence.jdbc.driver : com.mysql.jdbc.Driver
                - javax.persistence.jdbc.url : jdbc:mysql://localhost:3306/jarvis
                - javax.persistence.jdbc.user : root
                - javax.persistence.jdbc.password : root


        - Retrive values from the db
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
            EntityManager em = emf.createEntityManager();
            Alien alien = em.find(Alien.class, 101);
            System.out.println(alien);

        - save values to the db
            - transaction ACID properties

                Alien alien = new Alien();
                alien.setAid(104);
                alien.setAname("New Alien");
                alien.setColor("Green");

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
                EntityManager em = emf.createEntityManager();

                EntityTransaction et = em.getTransaction();
                et.begin();
                em.persist(alien);
                et.commit();

 */

public class Notes {

}