/*

    NOTE:
    - Limitations of primitive data types
        1. You cannot store multiple data sets

    - Limitations of an array
        1. Arrays are fixed in size
        2. Arrays can ONLY hold homogenous data (int, String, char)
        3. Arrays lack ready made API's support for convenience

 */

public class _01_Intro {
    public static void main(String[] args) {

        // 1. You cannot store multiple data sets with primitive data types
        int a = 10;
        int b = 10;
        int c = 10;
        int d = 10;
        int e = 10;

        System.out.println(a + b + c + d + e);

        // 1. Arrays are fixed in size
        int[] array = new int[10000];
        System.out.println(array);

        // 2. Arrays can ONLY hold homogenous data (int, String, char)
        Student[] students = new Student[10];

        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();
        students[3] = new Student();
        // students[4] = new Book();

        Object[] library = new Object[10];
        library[0] = new Student();
        library[1] = new Student();
        library[2] = new Student();
        library[3] = new Book();
        library[3] = new Student();

        // 3. Arrays lack ready made API's support for convenience

    }
}

class Book {

}

class Student {

}