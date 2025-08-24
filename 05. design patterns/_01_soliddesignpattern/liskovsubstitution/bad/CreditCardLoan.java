package _01_soliddesignpattern.liskovsubstitution.bad;

public class CreditCardLoan implements LoanPayment {

    @Override
    public void doPayment(int amount) {
        // Logic goes here
    }

    @Override
    public void foreClosedLoan() {
        throw new UnsupportedOperationException("Fore closure is not allowed.");
    }

    @Override
    public void doRepayment(int amount) {
        throw new UnsupportedOperationException("Repayment is not allowed.");
    }

}
