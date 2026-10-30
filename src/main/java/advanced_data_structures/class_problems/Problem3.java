package advanced_data_structures.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Student {
    String rollNumber;
    String name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return rollNumber.equals(other.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        StringBuilder addResults = new StringBuilder();
        StringBuilder containsResults = new StringBuilder();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().trim().split("\\s+");

            Student student = new Student(input[1], input[2]);

            if (input[0].equals("ADD")) {
                if (members.add(student)) {
                    addResults.append("Added\n");
                } else {
                    addResults.append("duplicate rejected\n");
                }
            } else if (input[0].equals("CONTAINS")) {
                containsResults.append(
                    "contains: " + members.contains(student) + "\n"
                );
            }
        }

        System.out.print(addResults);
        System.out.println("member count " + members.size());
        System.out.print(containsResults);

        sc.close();
    }
}