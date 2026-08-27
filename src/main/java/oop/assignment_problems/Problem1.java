package oop.assignment_problems;
class BookInventory {
    String title;
    String author;
    int copiesAvailable;
    BookInventory(String t, String a, int c) {
        title = t;
        author = a;
        copiesAvailable = c;
    }
    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}
public class Problem1{
    public static void main(String[] args) {
        BookInventory b1 = new BookInventory("Clean Code", "Robert C. Martin", 3);
        BookInventory b2 = new BookInventory("Effective Java", "Joshua Bloch", 5);
        BookInventory b3 = new BookInventory("Refactoring", "Martin Fowler", 0);
        BookInventory b4 = new BookInventory("Design Patterns", "GoF", 2);
        BookInventory[] books = {b1, b2, b3, b4};
        for (BookInventory b : books) {
            b.printEntry();
        }
    }
}