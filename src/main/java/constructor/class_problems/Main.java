package constructor.class_problems;
class FeeAccount {
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}
class HostelFeeAccount extends FeeAccount {
    void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
class PaymentProcessor {
    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
        } else {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }
    void processBatch(FeeAccount[] accounts, double amount) {
        int hostelCount = 0;
        int dayScholarCount = 0;
        for (FeeAccount account : accounts) {
            if (account instanceof HostelFeeAccount) {
                processPayment(account, amount);
                hostelCount++;
            } else {
                processPayment(account, amount);
                dayScholarCount++;
            }
        }
        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
public class Main {
    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };
        PaymentProcessor processor = new PaymentProcessor();
        processor.processBatch(accounts, 60000);
    }
}