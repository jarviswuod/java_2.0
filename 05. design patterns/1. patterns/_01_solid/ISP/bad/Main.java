package _01_solid.ISP.bad;

public class Main {
    public static void main(String[] args) {

        DAOInterface DBconn = new DBDaoConnection();
        DBconn.openConnection();
        DBconn.openFile();
        DBconn.createRecord();
        DBconn.deleteRecord();

        DAOInterface fileConn = new FileDaoConnection();
        fileConn.openConnection();
        fileConn.openFile();
        fileConn.createRecord();
        fileConn.deleteRecord();
    }
}
