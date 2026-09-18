package inheritance_and_polymorphism.assignment_problems;

class Gymmember4 {
    protected int sessionsAttended;

    public Gymmember4(String memberId, int monthlyFee) {
        sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember4 extends Gymmember4 {
    private String trainerName;

    public PremiumMember4(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }

    public String getTrainerName() {
        return trainerName;
    }
}

public class Problem4 {

    public static String batchPrint(Gymmember4[] members) {
        StringBuilder result = new StringBuilder();

        for (Gymmember4 member : members) {
            result.append(member.displayInfo());

            if (member instanceof PremiumMember4) {
                PremiumMember4 premium = (PremiumMember4) member;
                result.append(" [Trainer via downcast: ")
                      .append(premium.getTrainerName())
                      .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Gymmember4 standard = new Gymmember4("MEM6", 1000);
        PremiumMember4 premium = new PremiumMember4("MEM7", 2000, "Coach Riya");

        Gymmember4[] members = {standard, premium};

        System.out.println(batchPrint(members));
    }
}