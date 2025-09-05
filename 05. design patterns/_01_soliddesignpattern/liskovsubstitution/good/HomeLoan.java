package _01_soliddesignpattern.liskovsubstitution.good;

public class HomeLoan implements SecureLoan {

    @Override
    public void doPayment(int amount) {
        // Logic here
    }

    @Override
    public void foreCloseLoan() {
        // Logic here
    }

    @Override
    public void doRepayment(int amount) {
        // Logic here
    }
}
