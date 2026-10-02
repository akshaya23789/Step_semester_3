package abstraction.assignment_problems;

interface WashType {
    int duration();
    double charge();
}

class Quick implements WashType {
    public int duration() { return 30; }
    public double charge() { return 20; }
}

class Normal implements WashType {
    public int duration() { return 45; }
    public double charge() { return 30; }
}

class Heavy implements WashType {
    public int duration() { return 60; }
    public double charge() { return 45; }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashingMachine {
    private boolean busy;

    boolean isFree() {
        return !busy;
    }

    void start() {
        busy = true;
    }

    void complete() {
        busy = false;
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType type;

    WashCycle(Student student, WashingMachine machine, WashType type) {
        this.student = student;
        this.machine = machine;
        this.type = type;
    }

    void start() {
        if (!machine.isFree()) {
            System.out.println("Machine is currently busy.");
            return;
        }

        machine.start();
        System.out.println(type.getClass().getSimpleName() + " wash started for "
                + student.name + " (" + type.duration() + " min).");
        System.out.println("Charge: ₹" + type.charge());
    }

    void complete() {
        machine.complete();
        System.out.println("Wash cycle completed. Machine is now free.");
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine();
        WashingMachine m2 = new WashingMachine();

        new WashCycle(asha, m1, new Quick()).start();
        new WashCycle(ravi, m1, new Heavy()).start();
        new WashCycle(ravi, m2, new Heavy()).start();

        m1.complete();
        System.out.println("M1 is now free.");

        new WashCycle(neha, m1, new Normal()).start();
    }
}