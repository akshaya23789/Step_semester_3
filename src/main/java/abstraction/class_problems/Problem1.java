package abstraction.class_problems;

abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double calculateCharge(int days) {
        return days * 70;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    void rent() {
        if (!vehicle.available) {
            System.out.println(vehicle.name + " is currently unavailable.");
            return;
        }

        vehicle.available = false;
        System.out.println(vehicle.name + " rented successfully by " + customer.name);
        System.out.println("Rental charge: $" + vehicle.calculateCharge(days));
    }

    void returnVehicle() {
        vehicle.available = true;
        System.out.println(vehicle.name + " returned by " + customer.name);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        Rental r1 = new Rental(sedan, c1, 3);
        r1.rent();

        Rental r2 = new Rental(sedan, c2, 2);
        r2.rent();

        r1.returnVehicle();

        Rental r3 = new Rental(suv, c3, 5);
        r3.rent();
    }
}