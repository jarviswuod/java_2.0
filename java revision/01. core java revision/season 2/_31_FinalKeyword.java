/*
 final String NAME= "Jarvis" // prevents any variable update
 final void methodName(){} // prevent overriding
 final class ClassName{} // prevents inheritance
 */

public class _31_FinalKeyword {
    public static void main(String[] args) {
        final String NAME = "Jarvis"; // prevents any variable update

        System.out.println(" NAME : " + NAME);

    }
}

final class ClassName { // prevents inheritance
    final void methodName() {
    } // prevent overriding
}