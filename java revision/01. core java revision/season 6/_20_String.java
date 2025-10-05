/*

    NOTES:
    - String methods:
        - toUpperCase()/ toLowerCase()
        - trim()
        - startsWith()/ endsWith()
        - isEmpty()
        - contains()
        - split()
        - String.join("", where)
        - indexOf()/ lastIndexOf()
        - replace(from, to)
        - equals(str)/ equalsIgnoreCase(str)
        - charAt(index)


    - StringBuffer/ StringBuilder methods:
        - length/ capacity
        - setLength(0);
        - intern()
        - toString();
        - append()
        - reverse()
        - subString(start, end)
        - insert(text, at)
        - delete(start, end)
        - replace(from, to, with)
        - null + empty
        - charAt(index)/ setCharAt(index, char)


    - StringBuffer/ StringBuilder catch
        - intern();
        - null + empty
        - toString()
        - shallow copy; subString()
        - setLength(0)
        - length and capacity
        - trimToSize()
        - largeBuilder = null;


        NOTE:
            - Compile-time concatenation -> pool
                 String s3 = "Hel" + "lo";

            - Runtime concatenation -> heap
                String prefix = "Hel";
                String s6 = prefix + "lo";
                String s7 = s6.intern(); -> Hello

                  // Interning moves heap strings to pool
                  // intern() returns pool reference



 */

public class _20_String {
    public static void main(String[] args) {

        String name = "Jarvis";
        name.replace("J", "K");
    }
}
