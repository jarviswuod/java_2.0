package _01_soliddesignpattern.interfacesegregation.good;

public class DBDaoConnection implements DAOInterface, DBInterface {

    @Override
    public void openConnection() {
        // Logic goes here
    }

    @Override
    public void createRecord() {
        // Logic goes here
    }

    @Override
    public void deleteRecord() {
        // Logic goes here
    }

}
