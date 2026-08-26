package oop.class_problems;
class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;
    PlacementRecord(String name, String comp, double lpa) {
        studentName = name;
        company = comp;
        packageLpa = lpa;
    }
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Problem1 {
    public static void main(String[] args) {

        PlacementRecord p1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord p2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord p3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        PlacementRecord[] records = {p1, p2, p3};

        for (PlacementRecord r : records) {
            r.printRecord();
        }
    }
}