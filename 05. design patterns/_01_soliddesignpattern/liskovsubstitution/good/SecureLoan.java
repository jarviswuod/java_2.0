package _01_soliddesignpattern.liskovsubstitution.good;

public interface SecureLoan extends LoanPayment {
    public void foreCloseLoan();

}
