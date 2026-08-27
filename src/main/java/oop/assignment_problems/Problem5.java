package oop.assignment_problems;
class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;
    CompanyEmployee(String name, double sal) {
        empName = name;
        salary = sal;
        employeeCount++;
    }
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
public class Problem5 {
    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee e2 = new CompanyEmployee("Arjun", 25000);
        CompanyEmployee e3 = new CompanyEmployee("Ravi", 45000);
        CompanyEmployee.printCompanyInfo();
    }
}