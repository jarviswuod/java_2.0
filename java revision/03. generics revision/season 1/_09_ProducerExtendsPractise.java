/*

    NOTES:
    void displayNumbers(List<? extends Number> numberList) {

        Number number = numberList.get(0);
            - For type safety reasons, Whatever number you try to read it will cast to Number object type


        Double number = numberList.get(0); // Type mismatch: cannot convert ? extends Number to Double
            - This is because the complier doesn't know what exactly is in the 'numberList'. You could be having an Integer or Long otherwise


        for (Number item : numberList) {    //  Same concept applies to the loop 'Number'
            System.out.println(item);
        }

        numberList.size(); //   Only READ methods are allowed to access Number(upperbound set) class 

        numberList.add(34); //  No CREATE or UPDATE methods are allowed
    }

 */

public class _09_ProducerExtendsPractise {
}