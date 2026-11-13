package sorting_algorithms.class_problems;

public class Problem5 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static class SplitResult {
        Node firstHalf;
        Node secondHalf;

        SplitResult(Node firstHalf, Node secondHalf) {
            this.firstHalf = firstHalf;
            this.secondHalf = secondHalf;
        }
    }

    public static SplitResult splitList(Node head) {

        if (head == null) {
            return new SplitResult(null, null);
        }

        if (head.next == null) {
            return new SplitResult(head, null);
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;

        slow.next = null;

        return new SplitResult(head, secondHalf);
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

        System.out.println("Test 1: Even length");
        SplitResult result1 = splitList(head1);

        System.out.print("First half: ");
        printList(result1.firstHalf);

        System.out.print("Second half: ");
        printList(result1.secondHalf);

        System.out.println();

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        System.out.println("Test 2: Odd length");
        SplitResult result2 = splitList(head2);

        System.out.print("First half: ");
        printList(result2.firstHalf);

        System.out.print("Second half: ");
        printList(result2.secondHalf);

        System.out.println();

        Node head3 = new Node(99);

        System.out.println("Test 3: Single node");
        SplitResult result3 = splitList(head3);

        System.out.print("First half: ");
        printList(result3.firstHalf);

        System.out.print("Second half: ");
        printList(result3.secondHalf);
    }
}
