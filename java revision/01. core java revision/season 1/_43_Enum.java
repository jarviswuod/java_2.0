/*

 OFFHEAD NOTES:

 */

public class _43_Enum {

    public static void main(String[] args) {

        Status status = Status.Started;

        switch (status) {
            case Started:
                System.out.println("Started successfully");
                break;
            case Running:
                System.out.println("Running successfully");
                break;
            case Paused:
                System.out.println("Paused successfully");
                break;
            case Resume:
                System.out.println("Resume successfully");
                break;
            case Stopped:
                System.out.println("Stopped successfully");
                break;
            default:
                System.out.println("Command not found");
                break;
        }

        if (status == Status.Started) {
            System.out.println("Started successfully");
        } else if (status == Status.Running) {
            System.out.println("Running successfully");
        } else if (status == Status.Paused) {
            System.out.println("Paused successfully");
        } else if (status == Status.Resume) {
            System.out.println("Resume successfully");
        } else if (status == Status.Stopped) {
            System.out.println("Stopped successfully");
        } else {
            System.out.println("Command not found");
        }
    }
}

enum Status {
    Started, Running, Paused, Resume, Stopped;
}
