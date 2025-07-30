/*

    OFFHEAD NOTES:
      - final variable → cannot be reassigned (constant)
      - final method → cannot be overridden
      - final class → cannot be extended/inherited

 */

public class _31_FinalKeyword {

    public static void main(String[] args) {

        Random random = new Random();
        System.out.println(random.getName());
        random.anyMethod();

        // AnotherRandomClass anotherRandomClass = new AnotherRandomClass();
        // anotherRandomClass.anyMethod();

    }
}

final class Random {
    protected final String name = "Jarvis";

    public String getName() {
        return name;
    }
    // The final field Random.name cannot be assigned
    // public void setName(String name) {
    // this.name = name;
    // }

    public void anyMethod() {
        System.out.println("Random method is here");
    }

}
// The type AnotherRandomClass cannot subclass the final class
// class AnotherRandomClass extends Random {
// @Override
// public void anyMethod() {
// System.out.println("From main sub-class");
// super.anyMethod();
// }
// }