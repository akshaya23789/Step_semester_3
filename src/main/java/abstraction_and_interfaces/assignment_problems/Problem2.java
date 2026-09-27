package abstraction_and_interfaces.assignment_problems;

abstract class ArtPiece {
    private static int counter = 2000;
    private final String pieceId;
    protected final String title;

    public ArtPiece(String title) {
        this.title = title;
        pieceId = "ART-" + (++counter);
    }

    public abstract String describe();

    String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return title + ": A painted artwork.";
    }
}

class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return title + ": A sculpted artwork.";
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Painting painting = new Painting("Sunset");
        Sculpture sculpture = new Sculpture("The Thinker");

        System.out.println(painting.describe());
        System.out.println(sculpture.describe());
        System.out.println(painting.getPieceId());
        System.out.println(sculpture.getPieceId());
    }
}