/*

    NOTES:
    - CamelCasing naming convension
         1. class, interface and record - Calc, Runnable
         2. varaibles & methods - marks(), show(), caluculaterAverageHeight()
         3. constants - PIE, BRAND


    - Try to use good names for your variables classes and methods so that it will be easy for others to read through and understand your codes

    - It's easy to create a project that works than to create a project that everyone understands

 */

public class _02_NamingVariablesInJava {

    public static void main(String[] args) {

        final double PIE = 3.1472;
        String name = "Jarvis";

        showName();

        System.out.println(PIE);
        System.out.println(name);

    }

    public static void showName() {
        System.out.println("Name Is jarvis");
    }
}