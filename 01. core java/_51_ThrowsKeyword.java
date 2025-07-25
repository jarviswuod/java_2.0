/*
        
    NOTE:
        - Throws send the error up the ladder (Ducking the exception)
        - You can throw exception to classes and methods
        - Never throw the exception in the main method coz the main method is called by JVM which causes the program to stop
    
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
