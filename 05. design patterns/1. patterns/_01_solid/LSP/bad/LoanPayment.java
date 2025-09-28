package _01_solid.LSP.bad;

public interface LoanPayment {

    void doPayment(int amount);

    void foreClosedLoan();

    void doRepayment(int amount);
}
