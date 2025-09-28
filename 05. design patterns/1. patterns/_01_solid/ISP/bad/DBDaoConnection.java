package _01_solid.ISP.bad;

public class DBDaoConnection implements DAOInterface {

    @Override
    public void openConnection() {
        // Connection logic here
    }

    @Override
    public void openFile() {
        // We are in DB Connection so no need to support open file
        throw new UnsupportedOperationException("Open File is not supported");
    }

    @Override
    public void createRecord() {
        // Create record logic
    }

    @Override
    public void deleteRecord() {
        // This is fine
    }
}
