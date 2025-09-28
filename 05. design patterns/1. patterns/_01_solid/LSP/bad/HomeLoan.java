package _01_solid.LSP.bad;

public class HomeLoan implements LoanPayment {

    @Override
    public void doPayment(int amount) {
        // Logic goes here
    }

    @Override
    public void foreClosedLoan() {
        // Logic goes here
    }

    @Override
    public void doRepayment(int amount) {
        // Logic goes here
    }
}
