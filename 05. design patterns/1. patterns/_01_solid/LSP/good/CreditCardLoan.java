package _01_solid.LSP.good;

public class CreditCardLoan implements LoanPayment {

    @Override
    public void doPayment(int amount) {
        // Logic goes here
    }

    @Override
    public void doRepayment(int amount) {
        // Logic here
    }
}
