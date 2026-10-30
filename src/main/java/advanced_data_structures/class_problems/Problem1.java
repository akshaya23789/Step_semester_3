package advanced_data_structures.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class BankAccount {
    String id;
    long balance;

    BankAccount(String id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract String withdraw(long amount);
}

class Savings extends BankAccount {
    Savings(String id, long balance) {
        super(id, balance);
    }

    String withdraw(long amount) {
        if (balance - amount < 1000) {
            return id + " rejected: minimum balance 1000";
        }

        balance -= amount;
        return id + " balance " + balance;
    }
}

class Current extends BankAccount {
    Current(String id, long balance) {
        super(id, balance);
    }

    String withdraw(long amount) {
        if (balance - amount < -5000) {
            return id + " rejected: overdraft limit 5000";
        }

        balance -= amount;
        return id + " balance " + balance;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().trim().split("\\s+");

            if (input[0].equals("Savings")) {
                accounts.put(input[1],
                    new Savings(input[1], Long.parseLong(input[2])));
            } else if (input[0].equals("Current")) {
                accounts.put(input[1],
                    new Current(input[1], Long.parseLong(input[2])));
            } else if (input[0].equals("WITHDRAW")) {
                BankAccount account = accounts.get(input[1]);

                if (account == null) {
                    System.out.println("Account not found");
                } else {
                    System.out.println(
                        account.withdraw(Long.parseLong(input[2]))
                    );
                }
            }
        }

        sc.close();
    }
}