package _03_Factory.factories;

public class LinuxOperatingSystem extends OperatingSystem {

    public LinuxOperatingSystem(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        // Windows command
    }

    @Override
    public void removeDir(String dir) {
        // Windows command
    }
}
