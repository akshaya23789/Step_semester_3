package abstraction.assignment_problems;

import java.util.ArrayList;

interface NotificationChannel {
    void send(String notice, String student);
}

class EmailChannel implements NotificationChannel {
    public void send(String notice, String student) {
        System.out.println("[Email -> " + student + "] " + notice);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String notice, String student) {
        System.out.println("[SMS -> " + student + "] " + notice);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String notice, String student) {
        System.out.println("[App -> " + student + "] " + notice);
    }
}

class NoticeStudent {
    String name;
    String department;
    ArrayList<NotificationChannel> channels = new ArrayList<>();

    NoticeStudent(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    ArrayList<String> departments = new ArrayList<>();

    Notice(String title, String... departments) {
        this.title = title;

        for (String department : departments)
            this.departments.add(department);
    }

    boolean valid() {
        return !title.isEmpty() && !departments.isEmpty();
    }
}

class NoticeBoard {
    ArrayList<NoticeStudent> students = new ArrayList<>();

    void addStudent(NoticeStudent student) {
        students.add(student);
    }

    void post(Notice notice) {
        if (!notice.valid()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title + "' posted.");

        for (NoticeStudent student : students) {
            if (notice.departments.contains(student.department)) {
                for (NotificationChannel channel : student.channels)
                    channel.send(notice.title, student.name);
            }
        }
    }
}

public class Problem5 {
    public static void main(String[] args) {
        NoticeStudent asha = new NoticeStudent("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        NoticeStudent ravi = new NoticeStudent("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));
        board.post(new Notice("Sports Day"));
    }
}