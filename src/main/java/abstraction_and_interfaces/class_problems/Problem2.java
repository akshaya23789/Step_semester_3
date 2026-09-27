package abstraction_and_interfaces.class_problems;

interface Printable {
    String printLabel();
}

class PackageBox implements Printable {
    private final String trackingCode;

    public PackageBox(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingCode;
    }
}

class Invoice implements Printable {
    private final String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}

public class Problem2 {
    static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        Printable[] items = {
            new PackageBox("TRK-88"),
            new Invoice("INV-42")
        };

        printAll(items);
    }
}