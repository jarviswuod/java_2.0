/*

    NOTES:
       - Enums are special classes for fixed sets of constants
       - Enum constants are implicitly `public`, `static`, and `final`
       - Useful for predefined values like days, states, levels, etc.
       - Enums can be used in switch statements and if conditions

 */

enum Status {
    Started, Running, Failed, Pending, Success;
}

public class _46_Enums {
    public static void main(String[] args) {

        Status status = Status.Running;

        // Switch statments with enums
        switch (status) {
            case Running:
                System.out.println("All good");
                break;
            case Started:
                System.out.println("System start successfully");
                break;
            case Success:
                System.out.println("Successfully Registered");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please wait");
                break;

            default:
                System.out.println("Done");
                break;
        }

        // If statments with enums
        if (status == Status.Running)
            System.out.println("All good");
        else if (status == Status.Started)
            System.out.println("System start successfully");
        else if (status == Status.Success)
            System.out.println("Successfully Registered");
        else if (status == Status.Failed)
            System.out.println("Try Again");
        else if (status == Status.Pending)
            System.out.println("Please wait");
        else
            System.out.println("Done");
    }
}