package _01_soliddesignpattern.interfacesegregation.good;

public class Main {
    public static void main(String[] args) {

        FileDaoConnection fileDaoConnection = new FileDaoConnection();
        fileDaoConnection.createRecord();
        fileDaoConnection.deleteRecord();
        fileDaoConnection.openFile();

        DBDaoConnection dbDaoConnection = new DBDaoConnection();
        dbDaoConnection.openConnection();
        dbDaoConnection.createRecord();
        dbDaoConnection.deleteRecord();
    }
}
