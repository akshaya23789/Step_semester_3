package inheritance_and_polymorphism.assignment_problems;

class Gymmember2 {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public Gymmember2(String memberId, int monthlyFee) {
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

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember2 extends Gymmember2 {
    protected String trainerName;

    public PremiumMember2(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }

    public String getTrainerName() {
        return trainerName;
    }
}

class EliteMember2 extends PremiumMember2 {
    private String lockerNumber;

    public EliteMember2(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber
                + " | Sessions: " + sessionsAttended;
    }
}

class GroupClassMember2 extends Gymmember2 {
    private String className;

    public GroupClassMember2(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }
}

public class Problem2 {

    public static String classifyGeneration(Gymmember2 member) {
        if (member instanceof EliteMember2) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember2) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Standard or Premium member";
    }

    public static int getTotalSessionsAttended(Gymmember2[] members) {
        int total = 0;

        for (Gymmember2 member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {
        Gymmember2 standardMember = new Gymmember2("MEM1", 1000);

        PremiumMember2 premiumMember =
                new PremiumMember2("MEM2", 2000, "Coach Riya");

        EliteMember2 eliteMember =
                new EliteMember2("MEM3", 3000, "Coach Arjun", "L12");

        GroupClassMember2 groupClassMember =
                new GroupClassMember2("MEM4", 1500, "Zumba");

        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        System.out.println(standardMember.displayInfo());
        System.out.println(premiumMember.displayInfo());
        System.out.println(eliteMember.displayInfo());
        System.out.println(groupClassMember.displayInfo());

        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));

        Gymmember2[] members = {
            premiumMember,
            eliteMember,
            groupClassMember
        };

        System.out.println(getTotalSessionsAttended(members));
    }
}