package _01_soliddesignpattern.interfacesegregation.bad;

/*

    NOTES:
    - This DAO interface defined to support data access using file system or database
        - So we have added openConnection and openFile for it
        - This is bad because we have accomodated all operations in a single interface

 */

public interface DAOInterface {
    public void openConnection();

    public void openFile();

    public void createRecord();

    public void deleteRecord();
}
