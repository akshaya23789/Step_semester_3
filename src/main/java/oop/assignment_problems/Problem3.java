package oop.assignment_problems;
class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;
    Employee(String id, String name, double sal) {
        empId = id;
        empName = name;
        salary = sal;
        isIntern = false;
    }
    Employee(String id, String name) {
        this(id, name, 0);
        isIntern = true;
    }
    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}
public class Problem3{
    public static void main(String[] args) {
        Employee e1 = new Employee("E-101", "Divya", 65000);
        Employee e2 = new Employee("E-102", "Arjun");
        e1.printProfile();
        e2.printProfile();
    }
}