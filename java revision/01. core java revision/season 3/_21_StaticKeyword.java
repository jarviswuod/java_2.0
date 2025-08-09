/*
 static class

 Belongs to a class member not an object member
 static methods cannot have non static variables
 static varaibles can exist inside non static methods
 For memory efficiency and shared access


 Animal.name = "RandomName";
 static void static methodName() {...}
 
    class User {
        static int userCount = 0;
        String name;

        User(String name) {
            this.name = name;
            userCount++; // shared, not duplicated
        }
    }

 */

public class _21_StaticKeyword {
    public static void main(String[] args) {

    }
}
