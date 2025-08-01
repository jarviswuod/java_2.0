/*

    NOTES:
       - A package groups related Java classes/interfaces for better organization
       - Declared at the top of the file (before imports)
       - Helps avoid naming conflicts and supports access control
       - Nested packages (e.g., tools.math) reflect folder structure


    ///////////////////////////////// Project file Structure
    codes
    - db
    - other
        - tools
             - AdvancedCalc.java
             - Calc.java
        - A.java
    - Demo.java


    ///////////////////////////////// A.java 
    package other;
    
    public class A {
        // code block
    }


    ///////////////////////////////// Calc.java 
    package other.tools;
    
    public class Calc {
        public int add() {
            // code block
        }
    }


    ///////////////////////////////// AdvancedCalc.java 
    package other.tools;
    
    public class AdvancedCalc extends Calc {
        public int add() {
            // code block
        }
    }

 */

// import java.lang.*; // imported by Default
// import other.*;
// import other.tools.*;

public class _34_Packages {
    public static void main(String[] args) {

    }
}