/*
 Enum
 Limit choice by havin selectors
 extends the Enum class

 */

public class _43_Enum {

    public static void main(String[] args) {

        Status status = Status.Stopped;

        if (status == Status.Restarted) {
            System.out.println("System restarted successfully");
        } else {
            System.out.println("Unknown value");
        }

        switch (status) {

            case Restarted:
                System.out.println("System restarted successfully");
                break;
            default:
                System.out.println("Unknown value");
                break;
        }

    }
}

enum Status {
    Started, Running, Restarted, Stopped, Terminated;
}
