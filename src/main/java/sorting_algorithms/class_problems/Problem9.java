package sorting_algorithms.class_problems;

public class Problem9 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertAtTailCircular(Node head, int value) {

        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;

        return head;
    }


    public static void printCircular(Node head) {

        if (head == null) {
            System.out.println("(empty list)");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data);
            current = current.next;

            if (current != head) {
                System.out.print(" -> ");
            }

        } while (current != head);

        System.out.println(" -> (back to head)");
    }

    public static void main(String[] args) {

        Node head1 = new Node(10);
        head1.next = head1;

        head1 = insertAtTailCircular(head1, 20);
        head1 = insertAtTailCircular(head1, 30);
        head1 = insertAtTailCircular(head1, 40);

        System.out.println("Test 1: Insert into existing circular list");
        printCircular(head1);

        System.out.println();

        Node head2 = null;

        head2 = insertAtTailCircular(head2, 50);

        System.out.println("Test 2: Insert into empty circular list");
        printCircular(head2);

        System.out.println();

        Node head3 = null;

        head3 = insertAtTailCircular(head3, 1);
        head3 = insertAtTailCircular(head3, 2);
        head3 = insertAtTailCircular(head3, 3);

        System.out.println("Test 3: Insert multiple nodes");
        printCircular(head3);
    }
}
