package advanced_data_structures.assignment_problems;

public class Problem5 {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static class CircularList {
        Node tail;

        void addLast(String name) {
            Node newNode = new Node(name);

            if (tail == null) {
                tail = newNode;
                tail.next = tail;
            } else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
        }

        void printTurns(int turns) {
            if (tail == null) {
                return;
            }

            Node current = tail.next;

            for (int i = 0; i < turns; i++) {
                System.out.print(current.name);

                if (i < turns - 1) {
                    System.out.print(" ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularList players = new CircularList();

        players.addLast("Asha");
        players.addLast("Ravi");
        players.addLast("Neha");

        players.printTurns(7);
    }
}