package inheritance_and_polymorphism.class_problems;

class Librarymember4 {
    private int booksBorrowed;

    public Librarymember4(String memberId, int borrowLimit) {
        booksBorrowed = 0;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class StudentMember4 extends Librarymember4 {
    private String course;

    public StudentMember4(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course +
                " | Books: " + getBooksBorrowed();
    }

    public String getCourse() {
        return course;
    }
}

public class Problem4 {
    public static String batchPrint(Librarymember4[] members) {
        StringBuilder result = new StringBuilder();

        for (Librarymember4 member : members) {
            result.append(member.displayInfo()).append(" | ");

            if (member instanceof StudentMember4) {
                StudentMember4 student = (StudentMember4) member;
                result.append("[Course via downcast: ")
                        .append(student.getCourse())
                        .append("] | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Librarymember4 member1 = new Librarymember4("LB5", 3);
        StudentMember4 member2 = new StudentMember4("STU6", 3, "ECE");

        System.out.println(batchPrint(
                new Librarymember4[]{member1, member2}
        ));
    }
}