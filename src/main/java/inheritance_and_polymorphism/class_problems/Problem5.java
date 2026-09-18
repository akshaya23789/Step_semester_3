package inheritance_and_polymorphism.class_problems;

class Librarymember5 {
    private final String memberNumber;
    private static int membersEnrolled = 0;
    private int booksBorrowed;

    public Librarymember5(int borrowLimit) {
        membersEnrolled++;
        memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class FacultyMember5 extends Librarymember5 {
    private String department;

    public FacultyMember5(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class Problem5 {

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static String processNightlyAudit(Librarymember5[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (Librarymember5 member : members) {
            if (member == null) {
                nullSkipped++;
            } else {
                processed++;

                if (member instanceof FacultyMember5) {
                    faculty++;
                } else {
                    regular++;
                }
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + faculty + " faculty | "
                + regular + " regular";
    }

    public static void main(String[] args) {
        Librarymember5 m1 = new Librarymember5(3);

        System.out.println(m1.getMemberNumber());
        System.out.println(Librarymember5.getMembersEnrolled());

        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");

        Librarymember5[] members = {
            new FacultyMember5(5, "Physics"),
            null,
            new Librarymember5(3)
        };

        System.out.println(processNightlyAudit(members));
    }
}