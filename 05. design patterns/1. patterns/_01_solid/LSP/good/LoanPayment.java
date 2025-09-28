package _01_solid.LSP.good;

public interface LoanPayment {

    void doPayment(int amount);

    void doRepayment(int amount);
}