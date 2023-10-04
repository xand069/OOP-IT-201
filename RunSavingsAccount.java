
package runsavingsaccount;

import java.util.Scanner;

public class RunSavingsAccount {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount savings = new SavingsAccount();

        
        System.out.print("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();
        SavingsAccount.setInterestRate(interestRate);
        
        System.out.print("Enter deposit amount: ");
        double initial = scanner.nextDouble();
        savings.deposit(initial);
        
        
        SavingsAccount.showBalance(savings);


        while (true) {
            System.out.print("Enter D to deposit, W to withdraw: ");
            char choice = scanner.next().charAt(0);

            if (choice == 'D' || choice == 'd') {
                System.out.print("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                savings.deposit(amount);
            } else if (choice == 'W' || choice == 'w') {
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                double withdrawnAmount = savings.withdraw(amount);
                if (withdrawnAmount > 0) {
                    System.out.println("Withdrawn amount: " + withdrawnAmount);
                } else {
                    System.out.println("Insufficient balance for withdrawal.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
             SavingsAccount.showBalance(savings);

           
             if (savings.getBalance() > 1000) {
                savings.addInterest();
                System.out.println("New Balance with Interest: " + savings.getBalance());
            }
        }  
    }
}