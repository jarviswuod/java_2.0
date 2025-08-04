/*

    OFFHEAD:
    mirror/ shallow copy
    null vs empty
    toString() new Strings
    length vs capacity
    bigSpace = null // freeing space
    intern()
    trimToSize()
    setLength()

 */

public class _20_Strings {
    public static void main(String[] args) {
        String name = "jarvis";
        System.out.println("toUpperCase : " + name.toUpperCase());
        System.out.println("toLowerCase : " + name.toLowerCase());
        System.out.println("length : " + name.length());
        System.out.println("charAt : " + name.charAt(0));
        System.out.println("lastIndexOf : " + name.lastIndexOf('i'));
        System.out.println("indexOf : " + name.indexOf('j'));
        System.out.println("equals : " + name.equals("Jarvis"));
        System.out.println("equalsIgnoreCase : " + name.equalsIgnoreCase("JARVIS"));

        StringBuilder sb = new StringBuilder();
        sb.append("Jarvis");
        sb.toString();
        sb.insert(6, " Wuod");
        sb.reverse();
        sb.reverse();
        sb.delete(11, 11);
        sb.length();
        sb.capacity();

        System.out.println(sb);

    }
}
