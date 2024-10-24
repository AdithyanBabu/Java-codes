import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import validating.Validation;


/*Account class*/
abstract class Account {
    String customerName;
    String accNo; //account number
    String accType; //account type
    double balance; // as balance is common to both the accounts

    Account(String customerName, String accNo, String accType) {
        this.customerName = customerName;
        this.accNo = accNo;
        this.accType = accType;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
            System.out.println("Updated balance: " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }


    public abstract void withdraw(); //abstract method for withdrawal

    public String getAccNo() { // for returning the current account number
        return accNo;
    }

}

/* Savings Account */
class Savings extends Account {
    double interestRate;

    public Savings(String customerName, String accNo) {
        super(customerName, accNo, "Savings"); //storing the values using super keyword
        this.interestRate = 0.5; // interest rate is initialized
    }

    public void calculateInterest() {

        Scanner sc = new Scanner(System.in);
        if (balance != 0) {
            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            double interest = balance * Math.pow((1 + interestRate / 100), years) - balance; //compounded for once a year
            balance += interest;
            System.out.println("Interest added for " + years + " years: " + interest);
            System.out.println("Balance after interest: " + balance);
        } else {
            System.out.println("Balance is zero, nothing to calculate");
        }
    }

    public void withdraw() { //definition of the abstract class for SAVINGS ACCOUNT

        Scanner sc = new Scanner(System.in);
        if (balance != 0) {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount <= balance) {
                balance -= amount;
                System.out.println("Amount withdrawn: " + amount);
                System.out.println("Updated balance: " + balance);
            } else {
                System.out.println("Insufficient balance to withdraw.");
            }
        } else {
            System.out.println("Nothing to withdraw");
        }
    }
}

/* Current Account */
class Current extends Account {
    double minBalance;
    double penalty;

    public Current(String customerName, String accNo) {
        super(customerName, accNo, "Current");
        this.minBalance = 250; //min balance to be hold in an account
        this.penalty = 50; //penalty to deduct
    }

    public void withdraw() { //definition of the abstract method for CURRENT ACCOUNT


        Scanner sc = new Scanner(System.in);
        if (balance > 0) {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (balance < amount) {
                System.out.println("Insufficient balance to withdraw");
            } else if (balance - amount < minBalance) { // for deducting the penalty if (balance < minBalance)
                balance -= (amount + penalty);
                System.out.println("Amount withdrawn: " + amount);
                System.out.println("Penalty imposed: " + penalty);
                if (balance < 0)
                    System.out.println("Updated balance after penalty: " + 0.0);
                else
                    System.out.println("Updated balance after penalty: " + balance);
            } else {
                balance -= amount;
                System.out.println("Amount withdrawn: " + amount);
                System.out.println("Updated balance: " + balance);
            }
        } else {
            System.out.println("Nothing to withdraw");
        }
    }
}

public class BankAccounts {
    static ArrayList<Account> accountsList = new ArrayList<>(); // arraylist to hold the account details
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        String choice;
        do {
            System.out.println("\n1. Add Account \n2. Operations \n3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.next();
            switch (choice) {
                case "1": {
                    addAccount();
                    break;
                }
                case "2": {
                    operations();
                    break;
                }
                case "3": {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                }
            }
        } while (!choice.equals("3"));
        sc.close();
    }

    static String existingAccountNumber() {
        Scanner sc = new Scanner(System.in);
        boolean isAccount = true;
        String acc = "";
        while (isAccount) {
            acc = sc.next();
            if(Validation.validNumber(acc)) {
                if (Integer.parseInt(acc) > 0) {     // Check if the input number is positive
                    boolean isValid = true; // for already existing account number
                    for (Account account : accountsList) { // Reset the index to 0 to check against all
                        // previously entered accounts
                        if (Objects.equals(acc, account.getAccNo())) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        isAccount = false;       // Account is valid, exit the loop
                    } else {
                        System.out.println("Account already exists. Enter another account number.");
                    }
                } else {
                    System.out.println("Account must be positive, enter another one.");
                }
            } else {
                System.out.println("Enter a valid account number");
            }
        }
        return acc;        // Return the valid ID
    }


    public static void addAccount() {
        System.out.print("Enter Customer Name: ");
        String customerName = Validation.validName(); // to validate the name
        System.out.print("Enter Account Number: ");
        String accNo = existingAccountNumber(); // to check the existing account number
        System.out.print("Enter Account Type (Savings/Current): ");
        String accType = Validation.validAccountType(); // to check the type of accType

        Account account; // initializing  the instance class Account

        //comparing the accounts
        if (accType.equalsIgnoreCase("Savings")) {
            account = new Savings(customerName, accNo);
        } else if (accType.equalsIgnoreCase("Current")) {
            account = new Current(customerName, accNo);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        accountsList.add(account);
        System.out.println("Account created successfully.");
    }

    /* to do the operations */
    public static void operations() {
        System.out.print("Enter Account Number: "); // to do operations on the specified accounts
        String accNo = sc.next();
        Account account = findAccountNumber(accNo);
        if (account != null) {
            getAccountSubMenu(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    /* to get the matching account by the account number*/
    public static Account findAccountNumber(String accNo) {
        for (Account account : accountsList) {
            if (account.getAccNo().equals(accNo)) {
                return account;
            }
        }
        return null;
    }

    /* menu driven method comprising the operations that can be done in an account*/
    public static void getAccountSubMenu(Account account) {
        String choice;
        System.out.println("\n:: Welcome, " + account.customerName); // for displaying the account holder name
        do {
            System.out.println("\n1. Deposit \n2. Withdraw \n3. Check Balance \n" +
                    "4. Calculate Interest (Savings only) \n5. Back to main menu");
            System.out.print("Enter choice: ");
            choice = sc.next();
            switch (choice) {
                case "1": {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                    break;
                }
                case "2": {
                    account.withdraw();
                    break;
                }
                case "3": {
                    account.displayBalance();
                    break;
                }
                case "4": {
                    if (account instanceof Savings) { // for checking if it's a savings account or not
                        ((Savings) account).calculateInterest();
                    } else {
                        System.out.println("Interest calculation is not available for Current accounts.");
                    }
                    break;
                }
                case "5": {
                    System.out.println("Back to Main menu...");
                    return;
                }
                default: {
                    System.out.println("Invalid Input");
                }
            }
        } while (true);
    }
}
