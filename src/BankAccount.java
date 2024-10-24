public class BankAccount {
    public static void main(String[] args) throws InterruptedException {

        // Create an Accounts object with an initial balance of 500
        Accounts acc = new Accounts(500);

        // Create two threads representing two people withdrawing from the same account
        Thread t1 = new Thread(new ShareAccount(50, acc), "Person-1");
        Thread t2 = new Thread(new ShareAccount(100, acc), "Person-2");

        // Start both threads
        t1.start();
        t2.start();

        // Ensure that thread t2 (Person-2) completes before continuing
        // This line means Person-1's withdrawal process happens first completely
        t2.join();
    }
}

// The ShareAccount class implements Runnable, allowing threads to withdraw from the same account
class ShareAccount implements Runnable {
    private final Accounts account;  // Shared account from which funds are withdrawn
    private final double withdrawnAmount;  // Amount to be withdrawn by this thread

    // Constructor for ShareAccount to initialize withdrawal amount and account
    ShareAccount(double withdrawnAmount, Accounts account) {
        this.account = account;
        this.withdrawnAmount = withdrawnAmount;
    }

    // The run() method is the thread's execution method
    public void run() {
        // Continuously attempt to withdraw as long as the account allows it
        while (account.getBalance(withdrawnAmount)) {
            try {
                // Sleep for 10 milliseconds to simulate processing time
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// The Accounts class holds the bank account balance and provides synchronized withdrawal methods
class Accounts {
    private double balance;  // Current balance of the account

    // Constructor to initialize the account with a specific balance
    Accounts(double balance) {
        this.balance = balance;
    }

    public boolean getBalance(double withdrawnAmount) {
        if (balance <= 0) {
            System.out.println("No balance amount left for " + Thread.currentThread().getName());
        }

        // Check if enough balance for withdrawal
        if (balance >= withdrawnAmount) {
            balance -= withdrawnAmount; // Deduct the amount
            System.out.println("Person: " + Thread.currentThread().getName() + " withdraws " + withdrawnAmount +
                    ", now the balance amount is: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds for " + Thread.currentThread().getName() +
                    ", current balance is: " + balance);
            return false;
        }
    }
}
