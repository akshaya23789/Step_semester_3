package abstraction.assignment_problems;

import java.util.ArrayList;

interface Seat {
    double getPrice();
}

class Regular implements Seat {
    public double getPrice() {
        return 150;
    }
}

class Premium implements Seat {
    public double getPrice() {
        return 250;
    }
}

class Recliner implements Seat {
    public double getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String time;
    ArrayList<String> bookedSeats = new ArrayList<>();

    Show(String time) {
        this.time = time;
    }

    boolean available(String seat) {
        return !bookedSeats.contains(seat);
    }
}

class Booking {
    Customer customer;
    Show show;
    ArrayList<String> seats = new ArrayList<>();
    ArrayList<Seat> types = new ArrayList<>();

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
    }

    void book(String seat, Seat type) {
        if (seats.size() == 6) {
            System.out.println("Maximum 6 seats allowed.");
            return;
        }

        if (!show.available(seat)) {
            System.out.println("Seat " + seat + " is already booked for this show.");
            return;
        }

        seats.add(seat);
        types.add(type);
        show.bookedSeats.add(seat);
    }

    void confirm() {
        double total = 0;

        for (Seat type : types)
            total += type.getPrice();

        System.out.println("Booking confirmed for " + customer.name + ": " + seats);
        System.out.println("Total: ₹" + total);
    }

    void cancel(boolean beforeShow) {
        if (!beforeShow) {
            System.out.println("Cancellation not allowed.");
            return;
        }

        show.bookedSeats.removeAll(seats);
        System.out.println(customer.name + "'s booking cancelled.");
        System.out.println("Seats " + seats + " released.");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Show show = new Show("7 PM");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Booking b1 = new Booking(asha, show);
        b1.book("A1", new Regular());
        b1.book("A2", new Regular());
        b1.book("F5", new Premium());
        b1.confirm();

        Booking b2 = new Booking(ravi, show);
        b2.book("A2", new Regular());
        b2.book("R1", new Recliner());
        b2.confirm();

        b1.cancel(true);

        Booking b3 = new Booking(neha, show);
        b3.book("A2", new Regular());
        b3.confirm();
    }
}