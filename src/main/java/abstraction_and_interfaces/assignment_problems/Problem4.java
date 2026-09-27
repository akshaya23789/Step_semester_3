package abstraction_and_interfaces.assignment_problems;

abstract class ClassroomDevice {
    public abstract String operate();
}

interface Chargeable {
    String charge();

    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {
    private final String assetTag;

    public Tablet(String assetTag) {
        this.assetTag = assetTag;
    }

    @Override
    public String operate() {
        return assetTag + ": Tablet is operating.";
    }

    @Override
    public String charge() {
        return assetTag + ": Charging tablet.";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + ": Charging tablet for " + minutes + " minutes.";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Tablet tablet = new Tablet("TAB-101");

        System.out.println(tablet.operate());
        System.out.println(tablet.charge());
        System.out.println(tablet.charge(30));
    }
}