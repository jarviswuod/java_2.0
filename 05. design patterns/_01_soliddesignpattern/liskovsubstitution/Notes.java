package _01_soliddesignpattern.liskovsubstitution;

/*

    NOTES:
    - Liskov Substitution principle; It states that whenever  we are creating a parent child relationship, parent class and subclass, both classes should be substitutable/ interchangable. that is, whenever we pass the parent class or child class both shold work. i.e both should be able to handle those scenarios

    - We have an interface LoanPayment, under LoanPayment we have 3 methods. This 3 methods have to be overriden by our next concrete class
    - LoanPayment can be implemented by HomeLoan and CreditCardLoan.
        - HomeLoad implements LoanPayment where its overriding all the methods; doPayment(), forCloseLoan(), doRepayment() with no issue
        - When we come to CreditCardLoad however, we only override 2 methods successfully, doPayment() and doRepayment(), when we attempt to do foreCloaseLoan, the operation become impossible, we throw UnsupportedOperationException

    - If we go to loan closure service, we have included the LoanPayment interface and it has the foreCloseLoan() method which intern calls the foreCloseLoan() for a method we have provided, we did receive at the constructor level
        - If we pass a HomeLoan in the constructor we are able to foreCloseLoan pretty easily with no issues, but when we attempt to pass the CreditCardLoan, we have an issue as it will throw the UnsupportedOperationException

        - This mean whenever we are passing the one of the child classes (from LoanPayment) we are not able to fully pass it, one of the operations is not perfoming right. This should not happen and by this we should make sure whatver the classes or whatever the implementation we provide all those should be substitutable

    - Under the good code, we have created a LoanPayment Interface which only does the doPayment() method from this LoanPayment we create extend another interface, SecureLoan interface, over here we have the foreCloseLoan() method, in sort whatever methods we have we only keep them in the interface level (separate)
    - Now if we go to HomeLoan class, we implement the SecureLoan interface, we have 2 methods we can implement at this level;
        - doPayment() {} -> from LoanPayment interface
        - foreCloseLoan() {} -> from SecureLoan interface

    - If we go under CreditCardLoan, we implement  LoanPayment interface which only has the doPayment() method to override

    - Now under LoanClosureService, we are only consuming the SecureLoan interface and whenever we are passing the SecureLoan it will have the foreCloseLoan() method and that will be executed
    - We changed out code to ensure it behaves properly whenever we are subsituting classes, in the bad code whenever we were substituting the classes it was throwing an exception in one of the  methods, but here we just change the behaviour itself such that the LoanPayment can only do the doPayment() while SecureLoan will do the foreCloseLoan() on top, this way whoever required this fucntionality can go ahead and pass the SecureLoan inteface and that way the code will work

 */

public class Notes {

}
