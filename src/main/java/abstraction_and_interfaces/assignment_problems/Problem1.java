package abstraction_and_interfaces.assignment_problems;

interface Ringable {
    String ring();
}

class AlarmClock implements Ringable {
    private final String name;

    public AlarmClock(String name) {
        this.name = name;
    }

    @Override
    public String ring() {
        return name + ": Ring ring!";
    }
}

class Doorbell implements Ringable {
    private final String name;

    public Doorbell(String name) {
        this.name = name;
    }

    @Override
    public String ring() {
        return name + ": Ding dong!";
    }
}

public class Problem1 {
    static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {
        Ringable[] devices = {
            new AlarmClock("Alarm"),
            new Doorbell("Front Door")
        };

        ringAll(devices);
    }
}