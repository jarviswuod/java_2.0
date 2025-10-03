package _02_OopPrinciples.Encapsulation.bad;

class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.balance = 100;
        System.out.println(account.balance);

        account.balance = -50;
        System.out.println(account.balance);
    }
}
