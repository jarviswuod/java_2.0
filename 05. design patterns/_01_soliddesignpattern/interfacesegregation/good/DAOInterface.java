package _01_soliddesignpattern.interfacesegregation.good;

/*

    NOTES:
    - This is good we will only include the DAO operations and segregate connection part so consumer can only implement the required interfaces

 */

public interface DAOInterface {

    public void createRecord();

    public void deleteRecord();
}
