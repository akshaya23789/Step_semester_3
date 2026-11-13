package sorting_algorithms.class_problems;

public class Problem2 {
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

    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);

        if (head == null) {
            return newNode;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

        return head;
    }

    public static void printList(DNode head) {
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
        DNode head = new DNode(1);
        head = insertAtTailDoubly(head, 2);
        head = insertAtTailDoubly(head, 3);
        head = insertAtTailDoubly(head, 4);

        System.out.println("After inserting 4:");
        printList(head);
        DNode emptyHead = null;
        emptyHead = insertAtTailDoubly(emptyHead, 7);

        System.out.println("After inserting 7 into an empty list:");
        printList(emptyHead);
    }
}
