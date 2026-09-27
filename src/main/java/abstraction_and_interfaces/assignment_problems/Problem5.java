package abstraction_and_interfaces.assignment_problems;

abstract class Drone {
    public abstract String fly();
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    private final String id;
    private final String location;

    public DeliveryDrone(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String fly() {
        return id + ": Delivery drone is flying.";
    }

    @Override
    public String getLocation() {
        return location;
    }
}

class ScoutDrone extends Drone {
    private final String id;

    public ScoutDrone(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return id + ": Scout drone is flying.";
    }
}

class GroundRobot implements Trackable {
    private final String id;
    private final String location;

    public GroundRobot(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }
}

public class Problem5 {
    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable trackable = (Trackable) o;
            return trackable.getLocation();
        }

        return "Tracking not available.";
    }

    public static void main(String[] args) {
        DeliveryDrone deliveryDrone = new DeliveryDrone("D-101", "Warehouse");
        ScoutDrone scoutDrone = new ScoutDrone("S-202");
        GroundRobot groundRobot = new GroundRobot("G-303", "Loading Dock");

        System.out.println(deliveryDrone.fly());
        System.out.println(getLocationIfTrackable(deliveryDrone));
        System.out.println(scoutDrone.fly());
        System.out.println(getLocationIfTrackable(scoutDrone));
        System.out.println(getLocationIfTrackable(groundRobot));
    }
}