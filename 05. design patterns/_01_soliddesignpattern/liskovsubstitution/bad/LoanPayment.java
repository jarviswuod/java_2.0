package _01_soliddesignpattern.liskovsubstitution.bad;

public interface LoanPayment {
    public void doPayment(int amount);

    public void foreClosedLoan();

    public void doRepayment(int amount);
}
