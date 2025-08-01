/*

    NOTES:
    - String methods
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


    - StringBuilder/StringBuffer methods:
         - length()
         - append(str)
         - insert(offset, str)
         - replace(start, end, str)
         - delete(start, end)
         - reverse()
         - toString()
         - capacity()/ ensureCapacity(min)
         - charAt(index)/ setCharAt(index, char)

 */

public class _20_String {
    public static void main(String[] args) {

        String mainName = "Jarvis";

        StringBuilder builderName = new StringBuilder("Jarvis");

        StringBuffer bufferName = new StringBuffer("Wuod");

        // String Methods
        mainName.length();
        mainName.charAt(0);
        mainName.contains("Jar");

        // StringBuilder Methods
        builderName.append(" is my friend");
        builderName.reverse();
        builderName.reverse();
        builderName.toString();

        // StringBuffer Methods
        bufferName.indexOf("is");
        bufferName.append(" is here ");
        bufferName.trimToSize();
        bufferName.insert(12, " and ain't smiling");

        System.out.println("mainName : " + mainName);
        System.out.println("builderName : " + builderName);
        System.out.println("bufferName : " + bufferName);
    }
}
