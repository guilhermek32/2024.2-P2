package A2025_03_09_Atividade4;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawalLimit;

    public Account(int number, String holder, double initialBalance, double withdrawalLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = initialBalance;
        this.withdrawalLimit = withdrawalLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Withdraw amount must be positive");
        }
        if (amount > withdrawalLimit) {
            throw new WithdrawLimitExceededException("The amount exceeds withdraw limit");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}