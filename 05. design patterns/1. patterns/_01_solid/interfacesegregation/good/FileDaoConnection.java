package _01_soliddesignpattern.interfacesegregation.good;

public class FileDaoConnection implements FileInterface, DAOInterface {

    @Override
    public void createRecord() {
        // Logic here
    }

    @Override
    public void deleteRecord() {
        // Logic here
    }

    @Override
    public void openFile() {
        // Logic here
    }

}
