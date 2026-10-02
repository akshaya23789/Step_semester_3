package abstraction.assignment_problems;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

abstract class Assignment {
    String title;
    int maxMarks;
    int dueDate;

    Assignment(String title, int maxMarks, int dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(double marks, int lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int maxMarks, int dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyPenalty(double marks, int lateDays) {
        return marks - marks * 0.10 * lateDays;
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int maxMarks, int dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyPenalty(double marks, int lateDays) {
        return marks - marks * 0.20 * lateDays;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    int submissionDate;
    private String status = "Submitted";

    Submission(Student student, Assignment assignment, int submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
    }

    void grade(double marks) {
        if (!status.equals("Submitted"))
            return;

        int lateDays = Math.max(0, submissionDate - assignment.dueDate);
        double finalMarks = assignment.applyPenalty(marks, lateDays);

        status = "Graded";
        System.out.println(student.name + " graded: " + finalMarks + "/" +
                assignment.maxMarks);
        System.out.println("Status: " + status);
    }

    void resubmit() {
        if (status.equals("Graded"))
            System.out.println("Cannot resubmit: '" + assignment.title +
                    "' has already been graded.");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding =
                new CodingAssignment("Linked List Lab", 50, 10);
        Assignment written =
                new WrittenAssignment("Design Essay", 50, 12);

        Submission s1 = new Submission(asha, coding, 10);
        Submission s2 = new Submission(ravi, written, 14);

        s1.grade(45);
        s2.grade(40);

        s1.resubmit();
    }
}
