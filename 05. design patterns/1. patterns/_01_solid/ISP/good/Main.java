package _01_solid.ISP.good;

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
