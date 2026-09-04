package constructor.class_problems;
public class FeeAccountTracker {
    String regNo;
    double totalFee;
    public FeeAccountTracker(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }
    public final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }
    public final void printSummary(int daysLate) {
        double lateFee = calculateLateFee(daysLate);
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
    }
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};
        for (int i = 0; i < regNos.length; i++) {
            FeeAccountTracker account = new FeeAccountTracker(regNos[i], totalFees[i]);
            if (daysLate[i] <= 0) {
                System.out.println(account.regNo + " - On time, no late fee");
            } else {
                account.printSummary(daysLate[i]);
            }
        }
    }
}