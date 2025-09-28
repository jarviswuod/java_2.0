package _01_solid.LSP.good;

public class LoanClosureService {

    private SecureLoan secureLoan;

    public LoanClosureService(SecureLoan secureLoan) {
        this.secureLoan = secureLoan;
    }

    public void foreClosedLoan() {
        secureLoan.foreCloseLoan();
    }
}
