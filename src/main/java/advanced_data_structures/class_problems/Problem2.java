package advanced_data_structures.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Chargeable {
    void charge();
}

abstract class Vehicle {
    String passNumber;
    String owner;

    Vehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }

    abstract int getFee();

    abstract String getType();
}

class Bike extends Vehicle {
    Bike(String id, String owner) {
        super(id, owner);
    }

    int getFee() {
        return 300;
    }

    String getType() {
        return "Bike";
    }
}

class Car extends Vehicle {
    Car(String id, String owner) {
        super(id, owner);
    }

    int getFee() {
        return 1000;
    }

    String getType() {
        return "Car";
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String id, String owner) {
        super(id, owner);
    }

    int getFee() {
        return 300;
    }

    String getType() {
        return "EBike";
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String id, String owner) {
        super(id, owner);
    }

    int getFee() {
        return 1000;
    }

    String getType() {
        return "ECar";
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().trim().split("\\s+");

            if (input[0].equals("PASS")) {
                String type = input[1];
                String id = input[2];
                String owner = input[3];

                Vehicle v = null;

                switch (type) {
                    case "Bike":
                        v = new Bike(id, owner);
                        break;
                    case "Car":
                        v = new Car(id, owner);
                        break;
                    case "EBike":
                    case "E-Bike":
                        v = new EBike(id, owner);
                        break;
                    case "ECar":
                    case "E-Car":
                        v = new ECar(id, owner);
                        break;
                }

                if (v != null) {
                    vehicles.put(id, v);
                    System.out.println(
                        id + " (" + v.getType() + ") pass fee " + v.getFee()
                    );
                }
            } else if (input[0].equals("CHARGE")) {
                String id = input[1];
                Vehicle v = vehicles.get(id);

                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).charge();
                } else {
                    System.out.println(id + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}