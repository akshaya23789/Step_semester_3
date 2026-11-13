package sorting_algorithms.class_problems;

public class Problem1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data);
            current = current.next;

            if (current != head) {
                System.out.print(" ");
            }
        } while (current != head);

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head.next = second;
        second.next = third;
        third.next = head;

        System.out.println("Circular Linked List:");
        printCircular(head);

        System.out.println("Empty Circular Linked List:");
        printCircular(null);

        Node single = new Node(50);
        single.next = single;

        System.out.println("Single Node Circular Linked List:");
        printCircular(single);
    }
}
