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
