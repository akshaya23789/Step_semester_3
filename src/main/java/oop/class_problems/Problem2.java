package oop.class_problems;
class MessWallet {
    private double balance;
    public MessWallet(double amount) {
        if (amount < 0) {
            balance = 0;
            System.out.println("Warning: Negative opening balance so starting at 0");
        } else {
            balance = amount;
        }
    }
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: invalid amount");
        } else {
            balance = balance + amount;
        }
    }
    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance = balance - amount;
        }
    }
    public double getBalance() {
        return balance;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
