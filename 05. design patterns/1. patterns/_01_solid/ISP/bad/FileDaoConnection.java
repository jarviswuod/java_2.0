package _01_solid.ISP.bad;

public class FileDaoConnection implements DAOInterface {

    @Override
    public void openConnection() {
        // We can't open connection in file system
        throw new UnsupportedOperationException("Open Connection is not supported");
    }

    @Override
    public void openFile() {
        // Open File logic here
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
