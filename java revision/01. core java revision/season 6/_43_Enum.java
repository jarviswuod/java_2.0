/*

    NOTES:
    - A class that provides a limited number of object choice
    - Can be used in if or switch statements
    - Enum constants are implicitly `public`, `static`, and `final`
    - Enums are special classes for fixed sets of constants

 */

public class _43_Enum {
    public static void main(String[] args) {

        Names name = Names.Jarvis;

        switch (name) {
            case Jarvis:
                System.out.println("Name me Jarvis");
                break;
            case Wuod:
                System.out.println("Name me Wuod");
                break;
            case Lasty:
                System.out.println("Name me Lasty");
                break;

            default:
                System.out.println("No such name");
                break;
        }

        if (name == Names.Jarvis) {
            System.out.println("Name me Jarvis");
        } else if (name == Names.Wuod) {
            System.out.println("Name me Wuod");
        } else if (name == Names.Lasty) {
            System.out.println("Name me Lasty");
        } else if (name == Names.Jarvis) {
            System.out.println("Name me Jarvis");
        } else {
            System.out.println("No such name");
        }
    }
}

enum Names {

    Jarvis, Wuod, Lasty;
}