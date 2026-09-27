package abstraction_and_interfaces.class_problems;

abstract class DeliveryNote {
    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + " Signed by: " + signature;
    }
}

class ParcelNote extends DeliveryNote {
    @Override
    public String confirmDelivery() {
        return "Parcel delivery confirmed.";
    }
}

class LetterNote extends DeliveryNote {
    @Override
    public String confirmDelivery() {
        return "Letter delivery confirmed.";
    }
}

public class Problem5 {
    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        DeliveryNote[] notes = {
            new ParcelNote(),
            new LetterNote()
        };

        logAll(notes);

        DeliveryNote parcel = new ParcelNote();
        System.out.println(parcel.confirmDelivery("Alex"));
    }
}