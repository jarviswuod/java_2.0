package _01_solid.ISP;

/*

    NOTES:
    - Interface Segregation: It states that we should create an interface in such a way that those interfaces should have better method that needs to be implemented
    - You should not create a interface with 100's of methods that are not needed by the client


   
    - BAD EXAMPLE EXPLANATION:
        - Over here we have the DAOInterface interface with 4 methods we need to override when we implement the interface.
        - The interface is created in a way that it can access both file system and DB system then either create or delete a record
                public interface DAOInterface {
                    public void openConnection();
                    public void openFile();
                    public void createRecord();
                    public void deleteRecord();
                }

        - If we go to the DBDaoConnection concrete class, we implement the  DAOInterface for extentions with the DB, we override all methods until we are only left with openFile() because this is an open DB connection
                public class DBDaoConnection implements DAOInterface {
                    ....
                    @Override
                    public void openFile() {
                        throw new UnsupportedOperationException("Open File is not supported");
                    }
                }

        - For FileDaoConnection too, we can do openFile(), deleteRecord(), createRecord() file but we cannot open the DB connection because that's not what we are doing we are just connecting with a File
                public class FileDaoConnection implements DAOInterface {
                    ....
                    @Override
                    public void openConnection() {
                        throw new UnsupportedOperationException("Open Connection is not supported");
                    }
                }



    - GOOD EXAMPLE EXPLANATION:
        - We segregated the interfaces i.e we created a DAOInterface interface with only 2 methods, createRecord() and deleteReacord()
                public interface DAOInterface {
                    public void createRecord();
                    public void deleteRecord();
                }

        - We also created the DBInterface interface which allows openConnection() to the DB and finally we have the FileInterface interface which allows you to openFile()
                public interface DBInterface {
                    public void openConnection();
                }

                public interface FileInterface {
                    public void openFile();
                }

        - You notice all the interface have all different and appropriate methods as well, whenever we want to implement the FileDAOSystemConnection, we will implement both the FileInterface and DAOInterface, similar case with DBDaoSystemConnection, we have implement both  DAOInterface and DBInterface
                public class FileDaoConnection implements FileInterface, DAOInterface {...}
                public class DBDaoConnection implements DAOInterface, DBInterface {...}

        - The implementation is so neat such that we have different and multiple interfaces with their own responsibilities and whatever the client needs, clients can implement those needed interface accordingly to their requirement and not forcing the clients to implement any unwanted methods

 */

public class Notes {

}
