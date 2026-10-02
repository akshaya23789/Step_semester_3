package abstraction.assignment_problems;

interface MembershipPlan {
    double calculateFee();
}

class Monthly implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }
}

class Quarterly implements MembershipPlan {
    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }
}

class Annual implements MembershipPlan {
    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        System.out.println(member.name + " fee: ₹" + plan.calculateFee());
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member.name + " checked in.");
        else
            System.out.println("Check-in denied.");
    }

    void freeze() {
        if (status.equals("Active"))
            status = "Frozen";
        else
            System.out.println("Cannot freeze membership.");
    }

    void unfreeze() {
        if (status.equals("Frozen"))
            status = "Active";
        else
            System.out.println("Cannot unfreeze membership.");
    }

    void expire() {
        status = "Expired";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership m1 = new Membership(asha, new Quarterly());
        Membership m2 = new Membership(ravi, new Monthly());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}