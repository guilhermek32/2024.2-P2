package a2025_02_26_Atividade4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double limit = sc.nextDouble();

        Account account = new Account(number, holder, balance, limit);

        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        } catch (WithdrawLimitExceededException | InsufficientBalanceException | NegativeAmountException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        sc.close();
    }
}