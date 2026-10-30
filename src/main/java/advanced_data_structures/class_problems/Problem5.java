package advanced_data_structures.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Payslip {
    String name;
    String type;
    long pay;

    Payslip(String name, String type, long pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Payslip[name=" + name +
               ", type=" + type +
               ", pay=" + pay + "]";
    }
}

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract long calculatePay();

    abstract String getType();

    Payslip getPayslip() {
        return new Payslip(name, getType(), calculatePay());
    }
}

class FullTime extends Staff {
    long salary;

    FullTime(String name, long salary) {
        super(name);
        this.salary = salary;
    }

    long calculatePay() {
        return salary;
    }

    String getType() {
        return "FullTime";
    }
}

class PartTime extends Staff {
    long hours, rate;

    PartTime(String name, long hours, long rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    long calculatePay() {
        return hours * rate;
    }

    String getType() {
        return "PartTime";
    }
}

class Intern extends Staff {
    long stipend;

    Intern(String name, long stipend) {
        super(name);
        this.stipend = stipend;
    }

    long calculatePay() {
        return stipend;
    }

    String getType() {
        return "Intern";
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payslip> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().trim().split("\\s+");
            Staff staff = null;

            switch (input[0]) {
                case "FullTime":
                    staff = new FullTime(
                        input[1], Long.parseLong(input[2])
                    );
                    break;

                case "PartTime":
                    staff = new PartTime(
                        input[1],
                        Long.parseLong(input[2]),
                        Long.parseLong(input[3])
                    );
                    break;

                case "Intern":
                    staff = new Intern(
                        input[1], Long.parseLong(input[2])
                    );
                    break;
            }

            if (staff != null) {
                list.add(staff.getPayslip());
            }
        }

        sc.close();

        Payslip[] payslips = list.toArray(new Payslip[0]);
        long total = 0;
        int topper = 0;

        for (int i = 0; i < payslips.length; i++) {
            System.out.println(payslips[i]);
            total += payslips[i].pay;

            if (payslips[i].pay > payslips[topper].pay) {
                topper = i;
            }
        }

        System.out.println("Total " + total);

        if (payslips.length > 0) {
            System.out.println("top earner " + payslips[topper].name);
        }
    }
}