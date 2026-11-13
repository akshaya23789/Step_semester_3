package sorting_algorithms.class_problems;

public class Problem6 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseFirstK(Node head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        Node previous = null;
        Node current = head;
        Node nextNode = null;

        int count = 0;

        while (current != null && count < k) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
            count++;
        }

        head.next = current;

        return previous;
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

        System.out.println("Test 1: Reverse first 3 nodes");
        System.out.print("Original: ");
        printList(head1);

        head1 = reverseFirstK(head1, 3);

        System.out.print("Result:   ");
        printList(head1);

        System.out.println();

        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);

        System.out.println("Test 2: k greater than list length");
        head2 = reverseFirstK(head2, 5);

        System.out.print("Result:   ");
        printList(head2);

        System.out.println();

        Node head3 = new Node(7);
        head3.next = new Node(8);
        head3.next.next = new Node(9);

        System.out.println("Test 3: k = 0");
        head3 = reverseFirstK(head3, 0);

        System.out.print("Result:   ");
        printList(head3);
    }
}
