package inheritance_and_polymorphism.assignment_problems;

class Gymmember1 {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public Gymmember1(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid monthly fee");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {
            try {
                new Gymmember1(memberId, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

class PremiumMember1 extends Gymmember1 {
    private String trainerName;

    public PremiumMember1(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }
}

public class Problem1 {

    public static void main(String[] args) {
        PremiumMember1 p = new PremiumMember1("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        String[] memberIds = {
            "MEM1",
            "GM1",
            "MEM2",
            " ",
            "MEM3"
        };

        System.out.println(Gymmember1.signUpBatch(memberIds, 1000));
    }
}