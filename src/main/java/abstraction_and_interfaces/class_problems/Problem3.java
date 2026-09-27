package abstraction_and_interfaces.class_problems;

abstract class Instrument {
    public Instrument() {
    }

    public abstract String play();
}

class StringInstrument extends Instrument {
    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return "Instrument: Playing a generic instrument.";
    }
}

class Violin extends StringInstrument {
    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + " StringInstrument: Playing a string instrument." + " Violin: Playing the violin.";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Violin violin = new Violin();
        System.out.println(violin.play());
    }
}