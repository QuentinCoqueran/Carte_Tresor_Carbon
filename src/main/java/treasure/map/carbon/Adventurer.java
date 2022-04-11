package treasure.map.carbon;

public class Adventurer {
    private String name;
    private int numberOfTreasures;
    private Orientation orientation;
    private Position position;
    private String mouvements;


    public Adventurer(String name, int numberOfTreasures, Orientation orientation, Position position, String mouvements) {
        this.name = name;
        this.numberOfTreasures = numberOfTreasures;
        this.orientation = orientation;
        this.position = position;
        this.mouvements = mouvements;
    }

    @Override
    public String toString() {
        return "Adventurer{" +
                "name='" + name + '\'' +
                ", numberOfTreasures=" + numberOfTreasures +
                ", orientation=" + orientation +
                ", position=" + position +
                ", mouvements='" + mouvements + '\'' +
                '}';
    }

    public void move_foward() {
        switch (this.orientation){
            case North:
                this.position = this.position.goNorth();
                break;
            case South:
                this.position = this.position.goSouth();
                break;
            case West:
                this.position = this.position.goWest();
                break;
            case East:
                this.position = this.position.goEast();
                break;
        }
    }

    public void rotate_left() {
        switch (this.orientation){
            case North:
                this.orientation = Orientation.West;
                break;
            case West:
                this.orientation = Orientation.South;
                break;
            case South:
                this.orientation = Orientation.East;
                break;
            case East:
                this.orientation = Orientation.North;
                break;
        }
    }

    public void rotate_right() {
        switch (this.orientation){
            case North:
                this.orientation = Orientation.East;
                break;
            case South:
                this.orientation = Orientation.West;
                break;
            case East:
                this.orientation = Orientation.South;
                break;
            case West:
                this.orientation = Orientation.North;
                break;
        }
    }

    public void analyseMouvements(String[] mouvements) {
        for (String mouvement : mouvements) {
            switch (mouvement) {
                case "A":
                    this.move_foward();
                    break;
                case "G":
                    this.rotate_left();
                    this.move_foward();
                    break;
                case "D":
                    this.rotate_right();
                    this.move_foward();
                    break;
            }
        }
    }


    public String getName() {
        return name;
    }

    public int getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTreasures(int numberOfTreasures) {
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



