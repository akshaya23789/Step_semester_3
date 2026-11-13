package sorting_algorithms.class_problems;

public class Problem7 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int countNodes(Node head) {

        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
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
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);

        System.out.println("Test 1: List with five nodes");
        printList(head1);
        System.out.println("Number of nodes: " + countNodes(head1));

        System.out.println();

        Node head2 = null;

        System.out.println("Test 2: Empty list");
        printList(head2);
        System.out.println("Number of nodes: " + countNodes(head2));

        System.out.println();

        Node head3 = new Node(99);

        System.out.println("Test 3: Single-node list");
        printList(head3);
        System.out.println("Number of nodes: " + countNodes(head3));
    }
}
