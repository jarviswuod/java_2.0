package _01_soliddesignpattern.liskovsubstitution.bad;

/*

    NOTES:
    - This is loan interface responsible for payment related operations on loan account
    - LoanPayment implemented by actual loans like Home Loan, Credit Card Loan, etc
    - For both credit card or personal loans; unsecured, foreclosure, and replayment are not allowed

 */

public interface LoanPayment {
    public void doPayment(int amount);

    public void foreClosedLoan();

    public void doRepayment(int amount);
}
