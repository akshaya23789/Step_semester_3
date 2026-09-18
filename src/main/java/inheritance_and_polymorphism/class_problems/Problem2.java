package inheritance_and_polymorphism.class_problems;

class Librarymember {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    public Librarymember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("Borrow limit must be positive");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMember extends Librarymember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course +
                " | Books Borrowed: " + getBooksBorrowed();
    }

    public String getCourse() {
        return course;
    }
}

class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + getCourse() +
                " | Bonus Limit: " + bonusLimit +
                " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMember extends Librarymember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department +
                " | Books Borrowed: " + getBooksBorrowed();
    }
}

public class Problem2 {
    public static String classifyGeneration(Librarymember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        return "General member";
    }

    public static int getTotalBooksBorrowed(Librarymember[] members) {
        int total = 0;

        for (Librarymember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {
        Librarymember member1 = new Librarymember("STU1", 3);
        StudentMember member2 = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember member3 = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember member4 = new FacultyMember("STU4", 5, "Physics");

        System.out.println(member1.displayInfo());
        System.out.println(member2.displayInfo());
        System.out.println(member3.displayInfo());
        System.out.println(member4.displayInfo());

        System.out.println(classifyGeneration(member3));
        System.out.println(classifyGeneration(member4));

        member1.borrowBook();
        member2.borrowBook();
        member2.borrowBook();
        member3.borrowBook();
        member3.borrowBook();
        member4.borrowBook();

        System.out.println(getTotalBooksBorrowed(
                new Librarymember[]{member1, member2, member3, member4}
        ));
    }
}