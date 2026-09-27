package abstraction_and_interfaces.assignment_problems;

abstract class GardenTool {
    public GardenTool() {
    }

    public abstract String use();
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return "GardenTool: Using a garden tool.";
    }
}

class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + " CuttingTool: Cutting with a cutting tool." + " Pruner: Pruning branches.";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Pruner pruner = new Pruner();
        System.out.println(pruner.use());
    }
}