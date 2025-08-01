/*

    NOTES:
       - `throws` sends the exception up the call stack (Exception Ducking)
       - Lets the caller decide how to handle the exception
       - Can be used in methods and constructors
       - Avoid using `throws` in `main()` as unhandled exceptions will crash the program (JVM handles `main`)

   SYNTAX:
       - void methodName() throws Exception1, Exception2 { ... }

   EXAMPLE:
       - public void readFile() throws IOException { ... }
       - public void connectToDatabase() throws SQLException { ... }

*/

class A {
    public void show() throws ClassNotFoundException {
        Class.forName("Calc");
    }
}

public class _51_ThrowsKeyword {

    static {
        System.out.println("Class Loaded");
    }

    public static void main(String[] args) {
        A obj = new A();

        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
