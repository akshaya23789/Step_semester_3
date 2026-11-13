package sorting_algorithms.class_problems;

public class Problem8 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {

        Node head1 = null;

        System.out.println("Test 1: Empty linked list");
        System.out.println("Is empty? " + isEmpty(head1));

        System.out.println();

        Node head2 = new Node(10);

        System.out.println("Test 2: Single-node linked list");
        System.out.println("Is empty? " + isEmpty(head2));

        System.out.println();

        Node head3 = new Node(10);
        head3.next = new Node(20);
        head3.next.next = new Node(30);

        System.out.println("Test 3: Three-node linked list");
        System.out.println("Is empty? " + isEmpty(head3));
    }
}
