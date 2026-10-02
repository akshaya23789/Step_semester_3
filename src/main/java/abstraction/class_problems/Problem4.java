package abstraction.class_problems;

import java.util.ArrayList;

abstract class Room {
    String name;
    ArrayList<Reservation> reservations = new ArrayList<>();

    Room(String name) {
        this.name = name;
    }

    abstract double calculatePrice(int days);

    boolean available(int start, int end) {
        for (Reservation r : reservations)
            if (start < r.end && end > r.start)
                return false;
        return true;
    }
}

class StandardRoom extends Room {
    StandardRoom(String name) {
        super(name);
    }

    double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String name) {
        super(name);
    }

    double calculatePrice(int days) {
        return days * 150;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    int start, end;

    Reservation(Customer customer, Room room, int start, int end) {
        this.customer = customer;
        this.room = room;
        this.start = start;
        this.end = end;
    }

    void book() {
        if (!room.available(start, end)) {
            System.out.println(room.name + " is not available.");
            return;
        }

        room.reservations.add(this);
        System.out.println("Reservation confirmed for " + customer.name);
        System.out.println("Price: $" + room.calculatePrice(end - start));
    }

    void cancel(int currentDay, int deadline) {
        if (currentDay <= deadline) {
            room.reservations.remove(this);
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("Cancellation deadline has passed.");
        }
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Customer a = new Customer("Customer A");
        Customer b = new Customer("Customer B");
        Customer c = new Customer("Customer C");

        Room standard = new StandardRoom("Standard Room 101");
        Room deluxe = new DeluxeRoom("Deluxe Room 201");

        Reservation r1 = new Reservation(a, standard, 1, 5);
        r1.book();

        Reservation r2 = new Reservation(b, standard, 3, 7);
        r2.book();

        r1.cancel(2, 3);

        Reservation r3 = new Reservation(c, deluxe, 10, 12);
        r3.book();
    }
}