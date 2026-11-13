package sorting_algorithms.class_problems;
public class Problem10 {
    static class DNode {
        int data;
        DNode prev;
        DNode next;
        DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static DNode deleteLastNode(DNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;

        return head;
    }
    public static void printList(DNode head) {

        if (head == null) {
            System.out.println("(empty list)");
            return;
        }

        DNode current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DNode head1 = new DNode(10);
        DNode second = new DNode(20);
        DNode third = new DNode(30);
        DNode fourth = new DNode(40);

        head1.next = second;
        second.prev = head1;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        System.out.println("Test 1: Multiple nodes");
        System.out.print("Original: ");
        printList(head1);

        head1 = deleteLastNode(head1);

        System.out.print("After deletion: ");
        printList(head1);

        System.out.println();

        DNode head2 = new DNode(50);

        System.out.println("Test 2: Single node");
        System.out.print("Original: ");
        printList(head2);

        head2 = deleteLastNode(head2);

        System.out.print("After deletion: ");
        printList(head2);

        System.out.println();

        DNode head3 = null;

        System.out.println("Test 3: Empty list");
        head3 = deleteLastNode(head3);

        System.out.print("After deletion: ");
        printList(head3);
    }
}
