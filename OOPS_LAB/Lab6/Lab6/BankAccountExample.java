import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    // Constructor to initialize account details
    public Account(String customerName, int accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    // Method to accept deposit and update balance
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    // Method to compute and deposit interest
    public void depositInterest(double interestRate) {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest deposited. New balance: " + balance);
    }

    // Method to permit withdrawal and update balance
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // Method to check for minimum balance and impose penalty if necessary
    public void checkMinimumBalance(double minimumBalance, double penaltyAmount) {
        if (balance < minimumBalance) {
            balance -= penaltyAmount;
            System.out.println("Minimum balance not maintained. Penalty imposed. New balance: " + balance);
        } else {
            System.out.println("Minimum balance maintained. No penalty.");
        }
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String customerName, int accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current Account", initialBalance);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String customerName, int accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings Account", initialBalance);
    }
}

public class BankAccountExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        SavingsAccount savingsAccount = new SavingsAccount(customerName, accountNumber, initialBalance);
        CurrentAccount currentAccount = new CurrentAccount(customerName, accountNumber, initialBalance);

        System.out.println("Choose an operation:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display Balance");
        System.out.println("4. Deposit Interest");
        System.out.println("5. Check Minimum Balance");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                savingsAccount.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = sc.nextDouble();
                savingsAccount.withdraw(withdrawAmount);
                break;
            case 3:
                savingsAccount.displayBalance();
                break;
            case 4:
                System.out.print("Enter interest rate: ");
                double interestRate = sc.nextDouble();
                savingsAccount.depositInterest(interestRate);
                break;
            case 5:
                System.out.print("Enter minimum balance: ");
                double minBalance = sc.nextDouble();
                System.out.print("Enter penalty amount: ");
                double penaltyAmount = sc.nextDouble();
                savingsAccount.checkMinimumBalance(minBalance, penaltyAmount);
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
