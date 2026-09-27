package abstraction_and_interfaces.class_problems;

abstract class KitchenTool {
    private int speedLevel;

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
    }
}

interface Washable {
    String clean();
}

class Blender extends KitchenTool implements Washable {
    @Override
    public String prepare() {
        return "Blender: Blending ingredients.";
    }

    @Override
    public String clean() {
        return "Blender: Cleaning the blender.";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Blender blender = new Blender();

        blender.setSpeedLevel(3);

        System.out.println(blender.prepare());
        System.out.println("Speed level: " + blender.getSpeedLevel());
        System.out.println(blender.clean());
    }
}