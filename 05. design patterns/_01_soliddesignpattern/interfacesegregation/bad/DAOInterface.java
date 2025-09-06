package _01_soliddesignpattern.interfacesegregation.bad;

public interface DAOInterface {
    public void openConnection();

    public void openFile();

    public void createRecord();

    public void deleteRecord();
}
