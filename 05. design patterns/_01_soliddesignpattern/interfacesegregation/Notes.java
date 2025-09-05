package _01_soliddesignpattern.interfacesegregation;

/*

    NOTES:
    - Interface Segregation: It states that we should create an interface in such a way that those intefaces should have better method that needs to be implemented
    - You should not create a interface with 100's of methdos that are not needed by the client

    - BAD EXAMPLE EXPLANATION:
    - GOOD EXAMPLE EXPLANATION:

    
    - Example Explanation:
        - Over here we have the DAOInterface interface with 4 methods we need to override then we implement the interface. We have created it in such a way that it can access the file system as well as DB system both all them either it can do the file as well or it can open the Db connection as well, after that it can create or delete a record
        - If we go to the DBDaoConnection concrete class, we implement the  DAOInterface for extentions with the DB, we can do everything/ovveried every method until we are only left with openFile() method. We cannot openFile() because this is an open DB connection, we are throwing the UnsupportedOperationException
        - For FileDaoConnection too, we can do openFile(), deleteRecord(), createRecord() file but we cannot open the DB connection because that's not what we are doing we are just connecting with a File

    - If we proceed wiht the Good example:
        - What we did here is to segregate the interface i.e we created a DAOInterface interface with 2 methods, either createRecord(), or deleteReacord()
        - We also created the DBInterface interface and this interface will allow you to openConnection() to the DB and finally we have the FileInterface interface which allows you to openFile()
        - You notice all the interface have all different methods and appropriate methods as well, whenever we want to implement the file DAO system connection, we will implement both the FileInterface and DAOInterface,, similar case with DB DAO system connection, we have implement both  DAOInterface and DBInterface

        - The implementation is so neat such that we have different and multiple interfaces with their own responsibilities and whatever the client needs, clients can implement those needed interface accordingly to their requirement,,, We are not forcing the client implement or add the imeplementation of any methods

 */

public class Notes {

}
