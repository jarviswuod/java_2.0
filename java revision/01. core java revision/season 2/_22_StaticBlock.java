/*

    Static block and method only contains static methods, or variables

    static block intialises static variables
    it run once when class is loaded and no class has been isntaciated
 
 */

public class _22_StaticBlock {

    public static void main(String[] args) {

    }
}

class Student {

    static int numberOfStudents;
    int value;
    String name;

    static {
        numberOfStudents = 0;
        // name = "Jarvis";
    }

}