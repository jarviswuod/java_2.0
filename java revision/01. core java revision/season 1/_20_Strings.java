/*

    AI NOTES:
    String methods
         - length()
         - charAt(index)
         - substring(start, end)
         - toLowerCase()/ toUpperCase()
         - equals(str)/ equalsIgnoreCase(str)
         - contains(str)
         - indexOf(str)/ lastIndexOf(str)
         - startsWith(str)/ endsWith(str)
         - trim()
         - replace(old, new)
         - split(delimiter)
         - isEmpty()
         - join(delimiter, elements)
         - format(format, args...)

    StringBuilder/StringBuffer methods:
         - append(str)
         - insert(offset, str)
         - replace(start, end, str)
         - delete(start, end)
         - reverse()
         - toString()
         - capacity()
         - ensureCapacity(min)
         - setCharAt(index, char)
         - charAt(index)
         - length()



    OFFHEAD NOTES
      - Shallow copy
      - empty vs null
      - setLength(0) to reset/reuse
      - length() && capacity()
      - trimToSize()
      - intern()
      - toString() -> creates new String all the time it's called
      - largeBuilder = null; // Release large buffer

 */

public class _20_Strings {

    public static void main(String[] args) {

        String name = new String("jarvis");
        String anotherName = new String("Jarvis");
        String[] another = name.split("");
        String joinedBack = String.join("", another);
        String trimmedName = " Jarvis  ";

        for (String string : another) {
            System.err.print(string + " ");
        }

        System.out.println();
        System.out.println(joinedBack);
        System.out.println(trimmedName.trim().length());

        System.out.println("equals : " + name.equals(anotherName));
        System.out.println("equalsIgnoreCase : " +
                name.equalsIgnoreCase(anotherName));

        System.out.println();
        System.out.println();
        System.out.println();

        StringBuilder sBuilder = new StringBuilder("Wuod");
        System.out.println("sBuilder : " + sBuilder);

        StringBuffer sBuffer = new StringBuffer("wuod");
        System.out.println("sBuffer : " + sBuffer);
        sBuffer.append(0);

        synchronized (sBuilder) {
            sBuilder.append(trimmedName.trim());
        }
        System.out.println("sBuilder : " + sBuilder);
        System.out.println("sBuilder length : " + sBuilder.length());
    }
}
