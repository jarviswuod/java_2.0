package _01_solid.SRP;

/*

    NOTES:
    - Single responsibility principle:
        - It states that whatever class you create should have only have a single responsibility/ have only one reason to change 
        - To know if the principle is followed just ask one question, what responsibility your class does and when you discover "and" that means solid principle is NOT followed


    - BAD CODE EXPLAINED:
        - Account class:
            - Managing account information/data

                    public class Account {

                        private int accountNumber;
                        private String firstName;
                        private BigDecimal totalAmount;

                    }


        - AccountOperations class:
            - Managing accounts plus operations. A violation of Single Responsibility Principle

                    public class AccountOperations {

                        private static Map<Integer, Account> accountMap = new HashMap<>();

                        public void addAccount(Account account) {
                            accountMap.put(account.getAccountNumber(), account);
                        }

                        public void updateAccount(Account account) {
                            accountMap.put(account.getAccountNumber(), account);
                        }

                        public Account getAccount(int accountNumber) {
                            return accountMap.get(accountNumber);
                        }

                        // Move this method to different class
                        public void deposit(BigDecimal amount, int accountNumber) {
                            Account account = getAccount(accountNumber);
                            account.setTotalAmount(account.getTotalAmount().add(amount));
                        }

                        // Move this method to different class
                        public void withdraw(BigDecimal amount, int accountNumber) {
                            Account account = getAccount(accountNumber);
                            account.setTotalAmount(account.getTotalAmount().subtract(amount));
                        }
                    }


        - Main class:
            - Simulating Client Interaction
                    public class Main {

                        public static void main(String[] args) {

                            Account account = new Account();
                            account.setAccountNumber(123);
                            account.setFirstName("Wuod");
                            account.setTotalAmount(BigDecimal.valueOf(100000));

                            AccountOperations accountOperations = new AccountOperations();
                            accountOperations.addAccount(account);

                            // BAD - SINGLETON RULE BROKEN
                            accountOperations.deposit(BigDecimal.valueOf(123), 123);
                        }
                    }


        - OBSERVATION; ISSUE and SOLUTION:
            - AccountOperations violates the single responsibility as it has both 'account operations' and 'deposit' a 'transactions Operation' too. The deposit method should not be part of AccountOperations
            - Reason is account operations are responsible for doing operation for account like add account, update account get account. However deposit is something called as transaction which eventually not responsible by account. Adding this method violates Single Responsibility principle
                public void deposit(int amount, int accountNumber) {...}
                
            NOTE:
            - Create new class which actually does TransactionOperations



    - GOOD CODE EXPLAINED:
        - AccountOperations class:
            - Handling accounts Operations

                    public class AccountOperations {

                        private static Map<Integer, Account> accountMap = new HashMap<>();

                        public void addAccount(Account account) {
                            accountMap.put(account.getAccountNumber(), account);
                        }

                        public void updateAccount(Account account) {
                            accountMap.put(account.getAccountNumber(), account);
                        }

                        public Account getAccount(int accountNumber) {
                            return accountMap.get(accountNumber);
                        }
                    }


        - TransactionOperations class:
            - Handling Account transactions

                    public class TransactionOperations {

                        public void deposit(BigDecimal amount, int accountNumber) {

                            AccountOperations accountOperations = new AccountOperations();
                            Account account = accountOperations.getAccount(accountNumber);
                            account.setTotalAmount(account.getTotalAmount().add(amount));
                        }

                        public void withdraw(BigDecimal amount, int accountNumber) {

                            AccountOperations accountOperations = new AccountOperations();
                            Account account = accountOperations.getAccount(accountNumber);
                            account.setTotalAmount(account.getTotalAmount().subtract(amount));
                        }
                    }



        - OBSERVATION; ISSUE and SOLUTION:
            - TransactionOperations class is created to help handle deposit() and withdrawal() methods, this allows for single responsibility to be followed since AccountOperation does what is should to and TransactionOperations also does what is should do too

 */

public class Notes {
}
