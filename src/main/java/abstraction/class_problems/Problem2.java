package abstraction.class_problems;

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 10;
    }
}

class LeaveRequest {
    Employee employee;
    int days;
    String status = "Pending";

    LeaveRequest(Employee employee, int days) {
        this.employee = employee;
        this.days = days;
    }

    void approve() {
        if (status.equals("Pending") && employee.canTakeLeave(days))
            status = "Approved";
    }

    void reject() {
        if (status.equals("Pending"))
            status = "Rejected";
    }

    void setPending() {
        if (!status.equals("Pending"))
            System.out.println("Cannot change status to Pending.");
    }

    void showStatus() {
        System.out.println(employee.name + " - Status: " + status);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(john, 5);
        r1.showStatus();
        r1.approve();
        r1.showStatus();

        LeaveRequest r2 = new LeaveRequest(jane, 2);
        r2.showStatus();
        r2.reject();
        r2.showStatus();

        r1.setPending();
    }
}