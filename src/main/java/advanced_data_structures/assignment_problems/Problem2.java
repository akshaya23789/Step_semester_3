package advanced_data_structures.assignment_problems;

class OrderNode {
    int data;
    OrderNode next;

    OrderNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Problem2 {

    OrderNode head;

    // Add an order to the end of the list
    void addOrder(int orderId) {
        OrderNode newNode = new OrderNode(orderId);

        if (head == null) {
            head = newNode;
            return;
        }

        OrderNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Remove all cancelled orders matching the given order ID
    void removeCancelledOrder(int orderId) {

        // Remove matching orders from the beginning
        while (head != null && head.data == orderId) {
            head = head.next;
        }

        OrderNode current = head;

        while (current != null && current.next != null) {
            if (current.next.data == orderId) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Display all remaining orders
    void displayOrders() {
        if (head == null) {
            System.out.println("No orders remaining.");
            return;
        }

        OrderNode current = head;

        System.out.print("Orders: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Problem2 orders = new Problem2();

        orders.addOrder(101);
        orders.addOrder(102);
        orders.addOrder(103);
        orders.addOrder(102);
        orders.addOrder(104);
        orders.addOrder(102);

        System.out.println("Before removing cancelled orders:");
        orders.displayOrders();

        orders.removeCancelledOrder(102);

        System.out.println("After removing cancelled order 102:");
        orders.displayOrders();
    }
}