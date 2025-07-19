/*
   
    ----------------------------------------------------------- Sample 1.
    if(expression) {
        // Execute this block of code
    }

    
    ----------------------------------------------------------- Sample 2.
    if(expression) {
        // Execute this block of code
    } else {
        // Execute this other block of code
    }
  
    
    ----------------------------------------------------------- Sample 3.
    if(expression) {
        // Execute this block of code
    } else if(second expression){
        // Execute this other block of code
    } else {
        // Execute this block of code
    }
    
 */

public class _07_ConditionalOperators {
    public static void main(String[] args) {
        int age = 37;

        if (age > 18) {
            System.out.println("You are an adult");
        } else {
            System.out.println("You are a child");
        }
    }
}
