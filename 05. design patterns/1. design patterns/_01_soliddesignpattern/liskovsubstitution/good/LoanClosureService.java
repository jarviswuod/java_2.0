package _01_soliddesignpattern.liskovsubstitution.good;

public class LoanClosureService {
    private SecureLoan secureLoan;

    public LoanClosureService(SecureLoan secureLoan) {
        this.secureLoan = secureLoan;
    }

    public void foreClosedLoan() {
        secureLoan.foreCloseLoan();
    }
}
