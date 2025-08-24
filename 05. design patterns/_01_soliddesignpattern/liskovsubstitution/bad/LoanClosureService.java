package _01_soliddesignpattern.liskovsubstitution.bad;

/*

    NOTES:
    - We are unable to substitute subtype with super type. This is violation of Liskov Subsitution rule
    - Solution to this is to segregate the method in different supertypes and make subtype substitutable at any given time.

 */

public class LoanClosureService {

    private LoanPayment loanPayment;

    public LoanClosureService(LoanPayment loanPayment) {
        this.loanPayment = loanPayment;
    }

    public void foreClosedLoan() {
        loanPayment.foreClosedLoan();
    }
}
