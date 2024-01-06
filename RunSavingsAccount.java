import java.util.Scanner;

 class SavingsAccount {

    private double balance;
    public static double interestRate;

    public SavingsAccount() {
        balance = 0;
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
        } else {
            amount = 0;
        }
        return amount;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
    }

    public static void showBalance(SavingsAccount account) {
        double balance = account.getBalance();
        
        if (balance > 500) {
            account.addInterest();
            balance = account.getBalance();    
        }
        else if (balance > 1000) {
            account.addInterest();
            balance = account.getBalance();
        }
        System.out.println("Your Balance Is: " + balance);
    }
}

public class RunSavingsAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();
        SavingsAccount.setInterestRate(interestRate);

        SavingsAccount savings = new SavingsAccount();

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        savings.deposit(depositAmount);

        SavingsAccount.showBalance(savings);

        char choice;
        do {
            System.out.print("Press D for another deposit or W to withdraw: ");
            choice = scanner.next().charAt(0);

            if (choice == 'D' || choice == 'd') {
                System.out.print("Enter deposit amount: ");
                double deposit = scanner.nextDouble();
                savings.deposit(deposit);
            } else if (choice == 'W' || choice == 'w') {
                System.out.print("Enter withdrawal amount: ");
                double withdraw = scanner.nextDouble();
                savings.withdraw(withdraw);
            }

            SavingsAccount.showBalance(savings);

        } while (choice == 'D' || choice == 'd' || choice == 'W' || choice == 'w');

        System.out.println("Program terminated.");
    }
}
