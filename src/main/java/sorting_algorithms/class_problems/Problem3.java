package sorting_algorithms.class_problems;

public class Problem3 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirstKNodes(Node head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }

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

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        printList(head1);

        head1 = removeFirstKNodes(head1, 2);

        System.out.println("After removing first 2 nodes:");
        printList(head1);

        System.out.println();
        Node head2 = new Node(1);
        head2.next = new Node(2);

        head2 = removeFirstKNodes(head2, 5);

        System.out.println("After removing first 5 nodes:");
        printList(head2);

        System.out.println();
        Node head3 = new Node(10);
        head3.next = new Node(20);

        head3 = removeFirstKNodes(head3, 0);

        System.out.println("After removing first 0 nodes:");
        printList(head3);
    }
}
