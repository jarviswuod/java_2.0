/*

  AI NOTES:
    - The `static` keyword makes a member belong to the class, not instances.
    - It's mainly used for memory efficiency and shared access.
    - A static method can only access static variables or other static methods.
    - Examples: 
        - Static variable -> static String name = "";
        - Static method -> public static void methodName() { ... }
        - Static block -> static { ... }

 */

/*

  NOTES:
    - If 1000 User objects are created:
    - userCount is stored once.
    - name is stored 1000 times (one per object).
    - This reduces memory use and ensures shared data stays consistent.

 */

class User {
  static int userCount = 0;
  String name;

  User(String name) {
    this.name = name;
    userCount++; // shared, not duplicated
  }
}

public class _21_StaticKeyword {

  public static void main(String[] args) {

    Student student = new Student();
    student.enroll("Jarvis", "2 East");

    Student.register("Jarvis", "1 South"); // ✅ Correct usage of static method
  }
}

class Student {
  static int age = 9; // shared across all instances
  String name;
  String stream;

  static void register(String name, String stream) {
    // Cannot access non-static fields (name/stream) here
    System.out.println("Student named " + name + " of age " + age + " is registered to " + stream);
  }

  void enroll(String name, String stream) {
    // Can access static and non-static members
    System.out.println("Enrolling " + name + " to " + stream);
  }
}
