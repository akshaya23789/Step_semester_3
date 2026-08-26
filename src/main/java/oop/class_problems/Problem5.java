package oop.class_problems;
class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;
    Student(String n, int a) {
        name = n;
        attendance = a;
        studentCount++;
    }
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 95);
        Student.printCollegeInfo();
    }
}
