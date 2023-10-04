package runsavingsaccount;
import java.util.Scanner;

class SavingsAccount {
    private double balance;
    private static double interestRate = 0;

    public SavingsAccount() {
        this.balance = 0;
    }

    public static void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else {
            return 0;
        }
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
    }

    public static void showBalance(SavingsAccount account) {
        System.out.println("Current Balance: " + account.getBalance());
    }
}
