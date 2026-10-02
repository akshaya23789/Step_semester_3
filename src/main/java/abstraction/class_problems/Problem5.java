package abstraction.class_problems;

import java.util.ArrayList;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

interface PaymentMethod {
    boolean processPayment();
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment() {
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment() {
        return false;
    }
}

class Order {
    Customer customer;
    ArrayList<Product> products = new ArrayList<>();
    String status = "Pending";

    Order(Customer customer) {
        this.customer = customer;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void pay(PaymentMethod method) {
        if (products.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        if (method.processPayment()) {
            status = "Paid";
            System.out.println("Payment successful. Order status: " + status);
        } else {
            System.out.println("Payment failed. Order status: " + status);
        }
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Order o1 = new Order(x);

        o1.addProduct(new Product("Product A"));
        o1.addProduct(new Product("Product B"));
        o1.pay(new CreditCardPayment());

        Customer y = new Customer("Customer Y");
        Order o2 = new Order(y);
        o2.pay(new CreditCardPayment());

        Customer z = new Customer("Customer Z");
        Order o3 = new Order(z);
        o3.addProduct(new Product("Product C"));
        o3.pay(new PayPalPayment());
    }
}