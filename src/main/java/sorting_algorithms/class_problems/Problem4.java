package sorting_algorithms.class_problems;

public class Problem4 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node deleteNthNode(Node head, int n) {

        if (head == null || n <= 0) {
            return head;
        }

        if (n == 1) {
            return head.next;
        }

        Node current = head;

        for (int i = 1; i < n - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            return head;
        }

        current.next = current.next.next;

        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }

        Node current = head;

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

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Original list:");
        printList(head);

        head = deleteNthNode(head, 3);

        System.out.println("After deleting node at position 3:");
        printList(head);

        head = deleteNthNode(head, 1);

        System.out.println("After deleting node at position 1:");
        printList(head);

        head = deleteNthNode(head, 10);

        System.out.println("After trying to delete position 10:");
        printList(head);
    }
}
