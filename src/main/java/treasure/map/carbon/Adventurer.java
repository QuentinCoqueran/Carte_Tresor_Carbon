package treasure.map.carbon;

public class Adventurer {
    private String name;
    private Number numberOfTreasures;
    private Orientation orientation;
    private Position position;

    public Adventurer(String name, Number numberOfTreasures, Orientation orientation, Position position) {
        this.name = name;
        this.numberOfTreasures = numberOfTreasures;
        this.orientation = orientation;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Number getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTreasures(Number numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}



