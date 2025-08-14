/*

    NOTES:
    - Works Perfect (Invariance):
            Java:
                - Number int = new Integer(10);
                - Number doub = new Double(10);

            - Achieving covariance in generics
                - List<? extends Number> listOfVal = new ArrayList<Integer>();
                - List<? extends Number> listOfVal = new ArrayList<Number>();
                - List<? extends Number> listOfVal = new ArrayList<Double>();

    - Works Perfect & Doesnot work (Covariance):
            - List<? extends Number> listOfVal = new ArrayList<Integer>();      // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<Number>();       // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<Double>();       // Works Perfect
            - List<? extends Number> listOfVal = new ArrayList<String>();       // Doesnot work
            - List<? extends Number> listOfVal = new ArrayList<Object>();       // Doesnot work


    - You can't (WRITE): The compiler doesn't know what type of data you will be adding, you might decide to add different lists.
            // numberList.add(1);
            // numberList.add(4.5f);
            // numberList.add(4L);
            // numberList.add(23.0);

    - Whenever we are going to fetch something we can get Number only, that's the guarantee the complier is giving us.

            for (Number number : listOfNumbs) {
                System.out.println(number);
            }

    - This causes a Type mismatch as we have defined a List of Number to our generic List, meaning any Number could have been passed not only Integers

            for (Integer number : listOfNumbs) { // Type mismatch:
                System.out.println(number);
            }

 */

public class _08_ProducerExtends {
}