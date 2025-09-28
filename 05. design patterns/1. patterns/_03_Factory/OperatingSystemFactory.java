package _03_Factory;

import _03_Factory.factories.LinuxOperatingSystem;
import _03_Factory.factories.OperatingSystem;
import _03_Factory.factories.WindowsOperatingSystem;

public class OperatingSystemFactory {

    private OperatingSystemFactory() {
    }

    public static OperatingSystem getInstance(String type, String version, String architecture) {
        switch (type) {
            case "WINDOWS":
                return new WindowsOperatingSystem(version, architecture);
            case "LINUX":
                return new LinuxOperatingSystem(version, architecture);
            default:
                throw new IllegalArgumentException("OS Not supported");
        }
    }
}
