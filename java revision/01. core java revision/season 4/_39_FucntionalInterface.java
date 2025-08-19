
/*

    NOTES:
    - SAM / FunctionalInterface ::: One abstract method
     
 */

public class _39_FucntionalInterface {

}

@FunctionalInterface
interface Human {
    public void talk();

    default void canTalk() {
        System.out.println("Can do anything stupid anytime");
    }

    static void anotherTalk() {
        System.out.println("That's what I mean ");
    }
}
