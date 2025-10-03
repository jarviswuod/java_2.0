package _02_OopPrinciples.Encapsulation.good;

public class Main {
    public static void main(String[] args) {

        // BankAccount account = new BankAccount(-100);
        BankAccount account = new BankAccount(100);
        System.out.println(account.getBalance());

        account.deposit(50);
        System.out.println(account.getBalance());

        account.deposit(150);
        System.out.println(account.getBalance());

        account.widthdraw(150);
        System.out.println(account.getBalance());

        account.widthdraw(250);
        System.out.println(account.getBalance());

        account.widthdraw(-50);
        System.out.println(account.getBalance());
    }
}
