package inheritance_and_polymorphism.assignment_problems;

class Gymmember5 {
    private final String membershipNumber;
    private static int membersEnrolled = 0;
    private int feesPaid;

    public Gymmember5(int monthlyFee) {
        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class GroupClassMember5 extends Gymmember5 {
    private String className;

    public GroupClassMember5(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}

public class Problem5 {

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static String processWeeklyCheckIn(Gymmember5[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (Gymmember5 member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember5) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {
        Gymmember5 m1 = new Gymmember5(1000);

        System.out.println(m1.getMembershipNumber());
        System.out.println(Gymmember5.getMembersEnrolled());

        System.out.println(isValidReferralCode("G45B"));
        System.out.println(isValidReferralCode("G4B"));
        System.out.println(isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        Gymmember5[] members = {
                new GroupClassMember5(1500, "Zumba"),
                null,
                new Gymmember5(1000)
        };

        System.out.println(processWeeklyCheckIn(members));
    }
}