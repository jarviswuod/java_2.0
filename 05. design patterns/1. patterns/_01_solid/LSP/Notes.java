package _01_solid.LSP;

/*

    NOTES:
    - Liskov Substitution principle: It states that whenever we are creating a parent-child relationship, the sub-classes should be substitutable without breaking the program’s correctness
    - Whenever we pass the parent-class or child-class both should work. i.e both should be able to handle those scenarios


    - BAD EXAMPLE EXPLANATION:
        - We have an interface LoanPayment, under LoanPayment we have 3 methods. This 3 methods have to be overriden by our next concrete class

            public interface LoanPayment {

                public void doPayment(int amount);
                public void foreClosedLoan();
                public void doRepayment(int amount);
            }


        - LoanPayment interface is implemented by HomeLoan and CreditCardLoan
            - HomeLoan implements LoanPayment where it's overriding all the methods; doPayment(), forCloseLoan(), doRepayment() with no issue
                    public class HomeLoan implements LoanPayment {...}

            - In CreditCardLoan, only doPayment() and doRepayment() are valid. Since credit cards are unsecured, foreclosure isn’t applicable, so foreClosedLoan() throws an UnsupportedOperationException.
                    public class CreditCardLoan implements LoanPayment {
                        ...
                        
                        @Override
                        public void foreClosedLoan() {
                            throw new UnsupportedOperationException("Fore closure is not allowed.");
                        }
                    }

        - If we go to LoanClosureService, we have included the LoanPayment interface and it has the foreCloseLoan() method which intern calls the foreCloseLoan() for a class we've provided (received at the constructor level)
            - If we pass a HomeLoan in the constructor we are able to foreCloseLoan() pretty easily with no issues, but when we attempt to pass the CreditCardLoan(), we have an issue as it will throw the UnsupportedOperationException

        - ISSUE:
            - This mean whenever we are passing the one sub-classa an operation ain't not perfoming right, a violation of Liskov Substitution principle 


    - GOOD EXAMPLE EXPLANATION:
        - We create a LoanPayment Interface which does both doPayment() and doRepayment() methods
                public interface LoanPayment {
                    void doPayment(int amount);
                    void doRepayment(int amount);
                }

        - We extend the LoaPayment interface to create SecureLoan interface where we have the foreCloseLoan() method
                public interface SecureLoan extends LoanPayment {
                    public void foreCloseLoan();
                }

        - We implement SecureLoan interface to have HomeLoan class we have 2 methods we can implement at this level;
                - doPayment() {} -> from LoanPayment interface
                - doRepayment() {} -> from LoanPayment interface
                - foreCloseLoan() {} -> from SecureLoan interface

        - If we go under CreditCardLoan, we implement LoanPayment interface which we have doPayment() and doRepayment() methods to override
                public class CreditCardLoan implements LoanPayment {
                }

        - Now under LoanClosureService, we are only consuming the SecureLoan interface and whenever we are passing the SecureLoan it will have the foreCloseLoan() method and that will be executed
        - We change our code to ensure it behaves properly whenever we are substituting classes;
            - Under the bad code whenever we were substituting the classes an exception was thrown from a subclass method
            - Under the good code the behaviour is changed such that the LoanPayment can do the doPayment() and doRepayment() while SecureLoan will do the foreCloseLoan() on top.
            
            - This way whoever requires this functionality can go ahead and pass the SecureLoan inteface and that way the code will work

 */

public class Notes {
}