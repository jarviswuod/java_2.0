/*

   NOTES:
     - A static block is used to initialize static variables.
     - It runs ONCE when the class is loaded, before any object is created.
     - It can perform setup tasks without needing an object.
     - It executes before the constructor.
     - Only static methods and static variables are allowed inside static blocks or static methods.

*/

public class _22_StaticBlock {
    public static void main(String[] args) {

    }
}

class Student {

    static int age;
    static String name;
    String stream;

    static {
        age = 9;
        name = "Jarvis";
        // stream = "long";
    }
}