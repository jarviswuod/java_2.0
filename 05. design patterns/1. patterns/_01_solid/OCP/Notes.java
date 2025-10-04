package _01_solid.OCP;

/*

    NOTES:
    - Open-close principle:
        - It states that a class should be close for modification, extenstion should be allowed instead.
        - That is, suppose you create a class/ interface, nobody should be able to add an extra method to the class. Whatever extra functionalities that should be added, a new class should be created/ extend the parent-class and then add functionalities to this partiular sub-class


    - BAD EXAMPLE EXPLANATION:
        - Calculator class:
            - In this Calculator class we are passing 2 numbers(number1, number2) plus **type** (what we want to do). From this we use a switch statement to do everything. That is;
                - If you pass sum **type** we will be handling addition
                - If you pass sub **type** we will be handling subtraction


                    public class Calculator {

                        public int calcualatedNumber(int number1, int number2, String type) {

                            int result = 0;

                            switch (type) {
                                case "sum":
                                    result = number1 + number2;
                                    break;
                                case "sub":
                                    result = number1 - number2;
                                    break;

                                default:
                                    result = 0;
                                    break;
                            }

                            return result;
                        }
                    }


        - ISSUE:
            - Now suppose we want to add more operations like multiplication or division, then we need to manually come to the class and modify out code(the switch statement)
            - This is a violation of our open-closed principle, we should NOT be allowed
            - We overcome this scenario in the good calculator



    - GOOD EXAMPLE EXPLANATION:
        - Operation interface:
            - In this package, we are creating new interface called Operation and in this interface we have perform() method which takes 2 numbers
                    public interface Operation {

                        public int perform(int number1, int number2);
                    }


        - Concrete classes:
            - SubstractOperation & AddOperation classes:
                - This Operation interface will be implemented by any concrete class we want then override the perform method accordingly;
                    public class SubstractOperation implements Operation {

                        @Override
                        public int perform(int number1, int number2) {
                            return number1 - number2;
                        }
                    }

                    public class AddOperation implements Operation {

                        @Override
                        public int perform(int number1, int number2) {
                            return number1 + number2;
                        }
                    }


        - Calculator class:
            - Changes happen under out Calculate class; things are simple as we define a method 'calculateNumber' that takes 2 numbers and Operation interface we defined to do whatever operation we call;

                    public class Calculator {
                        public int calculateNumber(int number1, int number2, Operation operation) {
                            return operation.perform(number1, number2);
                        }
                    }


    - OBSERVATION; ISSUE and SOLUTION:
        - The Operation will be based and then operation.perform() method called;
            - Whenever we will be passing the addOperation, addition will happnen
            - Whenever we pass the pass the substraction, substraction will happen

        - If we want to introduce a new operation like division or multiplication, we can just implement the Operation interface then override the perform() method with a custom logic we want.
        - This way we are not allowing to modification of existing classes and methods, instead we extend the functionalities

*/

public class Notes {
}