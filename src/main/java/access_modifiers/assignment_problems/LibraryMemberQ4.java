package access_modifiers.assignment_problems;
class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
    }
    String getMembershipId() {
        return membershipId;
    }
    void setMembershipId(String id) {
        if (membershipId == null)
            membershipId = id;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    boolean isPremiumMember() {
        return premiumMember;
    }
    void setPremiumMember(boolean premium) {
        premiumMember = premium;
    }
    void setSecurityAnswer(String answer) {
        securityAnswer = Integer.toString(answer.hashCode());
    }
}
public class LibraryMemberQ4 {
    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        m.setSecurityAnswer("BlueMountain");
        System.out.println(m.getMembershipId());
        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());
        System.out.println(m.isPremiumMember());
    }
}