package oop.assignment_problems;
class PayrollAccount {
    private double basicSalary;
    private double bonus;
    PayrollAccount(double salary) {
        if (salary < 0) {
            basicSalary = 0;
            System.out.println("Warning: Negative opening salary starting at 0");
        } else {
            basicSalary = salary;
        }
        bonus = 0;
    }
    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit rejected: invalid bonus amount");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }
    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduct rejected: invalid tax percentage");
        } else {
            basicSalary = basicSalary - (basicSalary * (percent / 100.0));
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }
    double getNetSalary() {
        return basicSalary + bonus;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}