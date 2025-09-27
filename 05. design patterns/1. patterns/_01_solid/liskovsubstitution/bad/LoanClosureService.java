package _01_soliddesignpattern.liskovsubstitution.bad;

public class LoanClosureService {

    private LoanPayment loanPayment;

    public LoanClosureService(LoanPayment loanPayment) {
        this.loanPayment = loanPayment;
    }

    public void foreClosedLoan() {
        loanPayment.foreClosedLoan();
    }
}
