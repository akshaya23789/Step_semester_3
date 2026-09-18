package inheritance_and_polymorphism.assignment_problems;

import java.util.Arrays;

class Gymmember3 {
    private int[] lateFeeHistory = new int[10];
    private int feeCount;

    protected void chargeLateFee(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid fee amount");
        }

        if (feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, feeCount);
    }

    public int getTotalLateFees() {
        int total = 0;

        for (int fee : lateFeeHistory) {
            total += fee;
        }

        return total;
    }
}

class PremiumMember3 extends Gymmember3 {
    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class Problem3 {

    public static void main(String[] args) {
        PremiumMember3 member = new PremiumMember3();

        member.chargeLateFee(200);

        System.out.println(member.getTotalLateFees());

        int[] history = member.getLateFeeHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(member.getLateFeeHistory()));
    }
}