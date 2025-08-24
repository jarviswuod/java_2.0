package _01_soliddesignpattern.liskovsubstitution.good;

/*

    NOTES:
    - This is good we are bothered to provide the loan type
    - So this will behave perfectly fine even if we substitute between parent and child

 */

public class LoanClosureService {
    private SecureLoan secureLoan;

    public LoanClosureService(SecureLoan secureLoan) {
        this.secureLoan = secureLoan;
    }

    public void foreClosedLoan() {
        secureLoan.foreCloseLoan();
    }

}
